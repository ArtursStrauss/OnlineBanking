package lv.javaguru.java3OnlineBanking.core.api.jms;

public class CoreExceptionTypes {

    public static final String CORE_VALIDATION_ERROR = "CoreValidationError";
    public static final String CORE_INTERNAL_SERVER_ERROR = "InternalServerError";

    public static final String AMOUNT_LESS_OR_ZERO_ERROR = "AmountLessOrEqualsToZeroError";
    public static final String BALANCE_HAS_NOT_ENOUGH_RESOURCES_ERROR = "AccountBalanceHasNotEnoughResourcesError";
    public static final String RESOURCE_NOT_FOUND_ERROR = "ResourceNotFoundError";
}
