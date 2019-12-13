package com.example.workflows.api

import generated.com.example.flows.ExampleFlow_InitiatorPayload
import javax.annotation.Generated
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import org.web3j.corda.api.CorDapp
import org.web3j.corda.api.Flow
import org.web3j.corda.dapps.LifeCycle
import org.web3j.corda.model.core.transactions.SignedTransaction
import org.web3j.corda.protocol.ClientBuilder
import org.web3j.corda.protocol.CordaException
import org.web3j.corda.protocol.CordaService

/**
 *  CorDapp wrapper.
 */
@Generated(
    value = ["org.web3j.corda.codegen.CorDappClientGenerator"],
    date = "2019-12-05T05:09:49.189Z"
)
@Path("/api/rest/cordapps/workflows/")
interface Workflows : CorDapp {

    @get:Path("flows")
    override val flows: FlowResource

    interface FlowResource : org.web3j.corda.api.FlowResource {

        /**
         * Get the ExampleFlowInitiator flow.
         */
        @get:Path("com.example.flows.ExampleFlow\$Initiator")
        val exampleFlowInitiator: ExampleFlowInitiator

        /**
         * Workflows ExampleFlowInitiator flow.
         */
        interface ExampleFlowInitiator : Flow {

            /**
             * Start the ExampleFlowInitiator flow.
             */
            @POST
            @Produces("application/json")
            @Consumes("application/json")
            fun start(payload: generated.com.example.flows.ExampleFlow_InitiatorPayload):
                    org.web3j.corda.model.core.transactions.SignedTransaction
        }
    }

    /**
     * Workflows CorDapp lifecycle methods.
     */
    companion object : LifeCycle<Workflows> {

        /**
         * Loads an existing Workflows CorDapp instance.
         */
        override fun load(service: CordaService) = ClientBuilder.build(
            Workflows::class.java, service, CordaException.Companion::of
        )
    }
}
