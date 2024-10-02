package cloud.ambar.creditCardProduct.aggregate;

import cloud.ambar.common.models.AggregateTraits;
import cloud.ambar.common.models.Event;
import cloud.ambar.creditCardProduct.events.ProductActivatedEvent;
import cloud.ambar.creditCardProduct.events.ProductDeactivatedEvent;
import cloud.ambar.creditCardProduct.events.ProductDefinedEvent;
import cloud.ambar.creditCardProduct.models.PaymentCycle;
import cloud.ambar.creditCardProduct.models.RewardsType;
import lombok.Builder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductAggregate extends AggregateTraits {
    private static final Logger log = LogManager.getLogger(ProductAggregate.class);
    private String name;
    private int interestInBasisPoints;
    private int annualFeeInCents;
    private PaymentCycle paymentCycle;
    private int creditLimitInCents;
    private int maxBalanceTransferAllowedInCents;
    private RewardsType reward;
    private String cardBackgroundHex;
    private boolean active;

    @Builder
    public ProductAggregate(String aggregateId, long aggregateVersion, String name, int interestInBasisPoints, int annualFeeInCents, PaymentCycle paymentCycle, int creditLimitInCents, int maxBalanceTransferAllowedInCents, RewardsType reward, String cardBackgroundHex, boolean active) {
        super(aggregateId, aggregateVersion);
        this.name = name;
        this.interestInBasisPoints = interestInBasisPoints;
        this.annualFeeInCents = annualFeeInCents;
        this.paymentCycle = paymentCycle;
        this.creditLimitInCents = creditLimitInCents;
        this.maxBalanceTransferAllowedInCents = maxBalanceTransferAllowedInCents;
        this.reward = reward;
        this.cardBackgroundHex = cardBackgroundHex;
        this.active = active;
    }

    @Override
    public void transform(Event event) {
        switch(event.getEventName()) {
            case ProductDefinedEvent.EVENT_NAME -> log.info("Got ProductDefinedEvent");
            case ProductActivatedEvent.EVENT_NAME -> log.info("Got ProductActivatedEvent");
            case ProductDeactivatedEvent.EVENT_NAME -> log.info("Got ProductDeactivatedEvent");
        }
    }
}
