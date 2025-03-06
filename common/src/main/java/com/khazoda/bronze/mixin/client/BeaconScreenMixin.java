package com.khazoda.bronze.mixin.client;

import com.khazoda.bronze.registry.MainRegistry;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.BeaconScreen;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BeaconScreen.class)
public abstract class BeaconScreenMixin {
  @Inject(method = "renderBg", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;popPose()V", shift = At.Shift.AFTER))
  private void drawAfterIron(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY, CallbackInfo ci, @Local(ordinal = 2) int i, @Local(ordinal = 3) int j) {
    guiGraphics.renderItem(new ItemStack(MainRegistry.BRONZE_INGOT.get()), i + 42 + 64, j + 112);
  }

  @Inject(method = "renderBg", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;translate(FFF)V", shift = At.Shift.AFTER))
  private void drawBeforeIron(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY, CallbackInfo ci, @Local(ordinal = 2) int i, @Local(ordinal = 3) int j) {
    guiGraphics.renderItem(new ItemStack(MainRegistry.TIN_INGOT.get()), i + 42 + 68, j + 106);
  }
}