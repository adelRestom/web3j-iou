package com.example.client.workflows.api

import generated.com.example.flow.ExampleFlow_InitiatorPayload
import org.junit.Assert.assertTrue
import org.junit.jupiter.api.Test
import org.web3j.corda.network.network
import org.web3j.corda.network.nodes
import org.web3j.corda.network.notary
import org.web3j.corda.network.party
import java.io.File
import javax.annotation.Generated

@Generated(
    value = ["org.web3j.corda.codegen.CorDappClientGenerator"],
    date = "2019-12-20T02:08:15.227Z"
)
class WorkflowsTest {

    private val network = network {
        directory = File(System.getProperty("user.dir")).parentFile
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
            val nodeAIOU = nodeA.corda.api.vault.queryBy.contractStateType("com.example.state.IOUState")
                    .states[0].state!!.data
            assertTrue(nodeAIOU!!.participants!!.map { it.owningKey }!!
                    .containsAll(listOf(partyA.owningKey, partyB.owningKey)))

            // NodeB vault must contain the new IOU.
            val nodeBIOU = nodeB.corda.api.vault.queryBy.contractStateType("com.example.state.IOUState")
                    .states[0].state?.data
            assertTrue(nodeBIOU!!.participants!!.map { it.owningKey }!!
                    .containsAll(listOf(partyA.owningKey, partyB.owningKey)))
        }
    }
}
