package com.vomiter.rangedjs.mixin.model;

import com.llamalad7.mixinextras.sugar.Local;
import com.vomiter.rangedjs.item.bow.BowItemBuilder;

import com.vomiter.rangedjs.item.bow.BowRenderRegister;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = BowItemBuilder.class)
public class BowBuilderMixin {
    @Environment(EnvType.CLIENT)
    @Inject(method="createObject()Lnet/minecraft/world/item/Item;", at=@At("TAIL"))
    private void registerBowRenderProperties(CallbackInfoReturnable<Item> cir, @Local BowItem bowItem){
        BowRenderRegister.innerRegister(bowItem);
    }
}
