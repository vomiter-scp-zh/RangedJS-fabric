package com.vomiter.rangedjs.mixin.model;

import com.llamalad7.mixinextras.sugar.Local;
import com.vomiter.rangedjs.item.crossbow.CrossbowItemBuilder;
import com.vomiter.rangedjs.item.crossbow.CrossbowRenderRegister;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = CrossbowItemBuilder.class)
public class CrossbowBuilderMixin {
    @Environment(EnvType.CLIENT)
    @Inject(method="createObject()Lnet/minecraft/world/item/Item;", at=@At("TAIL"))
    private void registerBowRenderProperties(CallbackInfoReturnable<Item> cir,
                                             @Local CrossbowItem crossbowItem){
        CrossbowRenderRegister.innerRegister(crossbowItem);
    }
}
