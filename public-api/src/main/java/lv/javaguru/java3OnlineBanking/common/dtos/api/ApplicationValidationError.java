package lv.javaguru.java3OnlineBanking.common.dtos.api;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lv.javaguru.java3OnlineBanking.common.dtos.CoreValidationErrorDTO;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, visible = false, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CoreValidationErrorDTO.class)
})
public interface ApplicationValidationError {
}
