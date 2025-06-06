package br.com.taskmanager.application.domain.model;

public enum TaskStatus {

    PENDING("PENDING"),
    IN_PROGRESS("IN_PROGRESS"),
    COMPLETED("COMPLETED"),
    CANCELLED("CANCELLED");

    private final String status;

    TaskStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }

    public static boolean isValid(String value) {
        for (TaskStatus ts : TaskStatus.values()) {
            if (ts.name().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }

}
