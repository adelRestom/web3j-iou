package com.example.client.workflows.api

import com.example.state.IOUState;
import generated.com.example.flow.ExampleFlow_InitiatorPayload
import groovy.util.GroovyTestCase.assertEquals
import java.io.File
import javax.annotation.Generated
import org.junit.jupiter.api.Test
import org.web3j.corda.network.network
import org.web3j.corda.network.nodes
import org.web3j.corda.network.notary
import org.web3j.corda.network.party

@Generated(
        value = ["org.web3j.corda.codegen.CorDappClientGenerator"],
        date = "2019-12-05T05:09:49.189Z"
)
class WorkflowsTest {

    private val network = network {
        // Make sure that the directory is pointing to the root of the project.
        directory = File("/home/adel/corda/articles/web3j-iou")
        nodes {
            notary {
                name = "O=Notary, L=London, C=GB"
            }
            party {
                name = "O=PartyA, L=London, C=GB"
            }
            party {
                name = "O=PartyB, L=London, C=GB"
            }
        }
    }

    private lateinit var payload: ExampleFlow_InitiatorPayload

    @Test
    fun `start the ExampleFlowInitiator flow`() {
        // Populate the payload.
        val nodeA = network.parties[0]
        val nodeB = network.parties[1]
        val partyA = nodeA.corda.api.network.nodes
                .findByX500Name("O=PartyA, L=London, C=GB")[0].legalIdentities[0]
        val partyB = nodeB.corda.api.network.nodes
                .findByX500Name("O=PartyB, L=London, C=GB")[0].legalIdentities[0]
        payload = ExampleFlow_InitiatorPayload(10, partyB)

        // PartyA starts the flow with our payload (i.e. creates an IOU(lender: PartyA, borrower: PartyB, value: 10))
        Workflows.load(nodeA.corda.service).flows.exampleFlowInitiator.start(payload).apply {
            // NodeA vault must contain the new IOU.
            val nodeAIOU = nodeA.corda.api.vault.queryByContractStateType("com.example.state.IOUState")
                    .states[0].state?.data as IOUState
            assertEquals(partyA, nodeAIOU.lender)
            assertEquals(partyB, nodeAIOU.borrower)
            assertEquals(10, nodeAIOU.value)

            // NodeB vault must contain the new IOU.
            val nodeBIOU = nodeB.corda.api.vault.queryByContractStateType("IOUState")
                    .states[0].state?.data as IOUState
            assertEquals(partyA, nodeBIOU.lender)
            assertEquals(partyB, nodeBIOU.borrower)
            assertEquals(10, nodeBIOU.value)
        }
    }
}
