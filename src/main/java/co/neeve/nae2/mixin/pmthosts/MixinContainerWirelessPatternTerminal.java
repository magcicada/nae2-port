package co.neeve.nae2.mixin.pmthosts;


import appeng.container.implementations.ContainerWirelessPatternTerminal;
import appeng.helpers.WirelessTerminalGuiObject;
import co.neeve.nae2.common.interfaces.IPatternMultiToolToolboxHost;
import co.neeve.nae2.mixin.MixinContainerPatternEncoder;
import net.minecraft.entity.player.InventoryPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ContainerWirelessPatternTerminal.class)
public class MixinContainerWirelessPatternTerminal extends MixinContainerPatternEncoder implements IPatternMultiToolToolboxHost {
	@Inject(method =
		"<init>(Lnet/minecraft/entity/player/InventoryPlayer;Lappeng/helpers/WirelessTerminalGuiObject;)" + "V", at =
	@At(value = "INVOKE", target = "Lappeng/container/implementations/ContainerWirelessPatternTerminal;" +
		"bindPlayerInventory(Lnet/minecraft/entity/player/InventoryPlayer;II)V"))
	private void ctor(final InventoryPlayer ip, final WirelessTerminalGuiObject gui, CallbackInfo ci) {
		this.initializePatternMultiTool();
	}

	@Override
	public int getPatternMultiToolToolboxOffsetX() {
		return -63 - 18;
	}

	@Override
	public int getPatternMultiToolToolboxOffsetY() {
		return 43 + 16;
	}
}
