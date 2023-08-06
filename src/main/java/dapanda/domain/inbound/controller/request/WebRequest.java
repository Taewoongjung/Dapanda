package dapanda.domain.inbound.controller.request;

public class WebRequest {

        public record OrderProductWebRequestV1(int orderAmount, String categoryType) {
    }
}
