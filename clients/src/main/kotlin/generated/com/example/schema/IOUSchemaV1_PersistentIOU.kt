package generated.com.example.schema

import javax.annotation.Generated
import org.web3j.corda.model.core.schemas.PersistentStateRef

/**
*
* @param lenderName
* @param borrowerName
* @param value
* @param linearId
* @param stateRef
*/
@Generated(
    value = ["org.web3j.corda.codegen.CorDappClientGenerator"],
    date = "2019-12-19T05:21:14.911Z"
)
data class IOUSchemaV1_PersistentIOU(
    val lenderName: kotlin.String,
    val borrowerName: kotlin.String,
    val value: kotlin.Int,
    val linearId: java.util.UUID,
    val stateRef: org.web3j.corda.model.core.schemas.PersistentStateRef? = null
)
