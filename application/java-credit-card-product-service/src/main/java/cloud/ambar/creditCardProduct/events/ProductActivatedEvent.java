package cloud.ambar.creditCardProduct.events;

import cloud.ambar.creditCardProduct.aggregate.IEventTransformProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductActivatedEvent {
    public static final String EVENT_NAME = "CreditCardProduct_Product_ProductActivated";

    private String productIdentifierForAggregateIdHash;

}
