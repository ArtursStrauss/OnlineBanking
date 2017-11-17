package lv.javaguru.java3OnlineBanking.core.api.exceptions;

public class ResourceNotFoundException extends ApplicationException {

    private Long resourceId;

    public ResourceNotFoundException(Long resourceId, String message) {
        super(message);
        this.resourceId = resourceId;
    }
}
