package com.vomiter.rangedjs.item.bow;

import com.vomiter.rangedjs.item.ArrowShootingInterface;
import com.vomiter.rangedjs.item.context.BowReleaseContext;
import com.vomiter.rangedjs.item.context.BowUseContext;
import dev.latvian.mods.rhino.util.HideFromJS;
import dev.latvian.mods.rhino.util.RemapForJS;

import java.util.function.Consumer;

public interface BowItemInterface extends ArrowShootingInterface {

    @Override
    @HideFromJS
    default BowProperties rjs$getBowProperties(){return new BowProperties();}

    @Override
    @HideFromJS
    default BowUseBehavior rjs$getUseBehavior(){return (BowUseBehavior)rjs$getBowProperties().getUseBehavior();}

    @HideFromJS
    default BowAttributes rjs$getBowAttributes(){return rjs$getBowProperties().bowAttributes;}

    @Override
    @HideFromJS
    default Consumer<BowUseContext> rjs$getUseCallback(){return rjs$getUseBehavior().useCallback;}

    @Override
    @HideFromJS
    default Consumer<BowUseContext> rjs$getUseTickCallback(){return rjs$getUseBehavior().useTickCallback;}

    @Override
    @HideFromJS
    default Consumer<BowReleaseContext> rjs$getReleaseCallback(){return rjs$getUseBehavior().releaseCallback;}


    @RemapForJS("bow")
    @SuppressWarnings("unused")
    default BowItemInterface rjs$bow(Consumer<BowProperties> consumer){
        BowProperties properties = this.rjs$getBowProperties();
        consumer.accept(properties);
        this.rjs$setBowProperties(properties);
        return this;
    }
}
