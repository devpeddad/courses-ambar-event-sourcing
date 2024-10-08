package cloud.ambar.common.ambar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorMustRetry {

    @JsonProperty("result")
    private Result result = new Result();

    @Data
    @NoArgsConstructor
    public static class Result {

        @JsonProperty("error")
        private ErrorDetail error = new ErrorDetail("must_retry", "must retry it", "must retry it");

        @Data
        @NoArgsConstructor
        public static class ErrorDetail {

            @JsonProperty("policy")
            private String policy;

            @JsonProperty("class")
            private String errorClass;

            @JsonProperty("description")
            private String description;

            public ErrorDetail(String policy, String errorClass, String description) {
                this.policy = policy;
                this.errorClass = errorClass;
                this.description = description;
            }
        }
    }
}
