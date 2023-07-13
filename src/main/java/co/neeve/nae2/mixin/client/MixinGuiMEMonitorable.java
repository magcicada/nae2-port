package co.neeve.nae2.mixin.client;

import appeng.client.gui.implementations.GuiMEMonitorable;
import net.minecraft.inventory.Container;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.awt.*;
import java.util.List;

@Mixin(GuiMEMonitorable.class)
public class MixinGuiMEMonitorable extends MixinAEBaseMEGui {
	public MixinGuiMEMonitorable(Container inventorySlotsIn) {
		super(inventorySlotsIn);
	}

	@Inject(method = "getJEIExclusionArea", at = @At("RETURN"), remap = false)
	public void injectJEIAreas(CallbackInfoReturnable<List<Rectangle>> cir) {
		cir.getReturnValue().addAll(super.getJEIExclusionArea());
	}
}
