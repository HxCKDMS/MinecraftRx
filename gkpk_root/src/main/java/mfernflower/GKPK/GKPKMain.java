package mfernflower.GKPK;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;


// Current limitations of using inbuilt potion system as opposed to adding my own items:
// I cannot seem to make a brewing stand craft that requires more than one of something (could be my fault???)
// brewing this mod's pots with gunpowder, glowstone etc causes the pots to be replaced with effectless pots
// brewing this mod's pots requires you to attend the brewing stand as it has no potion done check and can just loop

@Mod("gkpk")
public class GKPKMain
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public GKPKMain() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("GKPK: start brewing register");
        // Getting high from magic mushrooms
        ItemStack magicshroom = new ItemStack(Items.POTION);
        magicshroom.setDisplayName(new StringTextComponent("\u00A7RWeak Psilocybin"));
        List<EffectInstance> effectshroom = new ArrayList<>();
        effectshroom.add(new EffectInstance(Effect.get(9), 1200,  0, false, false));
        effectshroom.add(new EffectInstance(Effect.get(24), 1200,  0, false, false));
        effectshroom.add(new EffectInstance(Effect.get(16), 1200,  0, false, false));
        PotionUtils.appendEffects(magicshroom, effectshroom);
        magicshroom.getTag().putInt("CustomPotionColor", 14792673);
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(Items.POTION)),Ingredient.fromStacks(new ItemStack(Items.BROWN_MUSHROOM_BLOCK)),magicshroom);
        // Hunger from flesh
        ItemStack hungerpot = new ItemStack(Items.POTION);
        hungerpot.setDisplayName(new StringTextComponent("\u00A7RVomiting mixture"));
        hungerpot.getTag().putInt("CustomPotionColor", 3551286);
        List<EffectInstance> effecthpot = new ArrayList<>();
        effecthpot.add(new EffectInstance(Effect.get(17), 600,  19, false, false));
        PotionUtils.appendEffects(hungerpot, effecthpot);
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(Items.POTION)),Ingredient.fromStacks(new ItemStack(Items.ROTTEN_FLESH)),hungerpot);
        // Sea pickles or something idk
        ItemStack picklejuice = new ItemStack(Items.POTION);
        List<EffectInstance> picklemagic = new ArrayList<>();
        picklemagic.add(new EffectInstance(Effect.get(29), 2400,  0, false, false));
        picklemagic.add(new EffectInstance(Effect.get(7), 0,  0, false, false));
        PotionUtils.appendEffects(picklejuice, picklemagic);
        picklejuice.setDisplayName(new StringTextComponent("\u00A7RSea Pickle Juice"));
        picklejuice.getTag().putInt("CustomPotionColor", 2663593);
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(Items.POTION)),Ingredient.fromStacks(new ItemStack(Items.SEA_PICKLE)),picklejuice);
        // poppies and morphine
        ItemStack morphinebottle = new ItemStack(Items.POTION);
        List<EffectInstance> morphine = new ArrayList<>();
        morphine.add(new EffectInstance(Effect.get(9), 500,  0, false, false));
        morphine.add(new EffectInstance(Effect.get(6), 0,  0, false, false)); // 2 hp heal as to not make overpowered
        PotionUtils.appendEffects(morphinebottle,morphine);
        morphinebottle.setDisplayName(new StringTextComponent("\u00A7RWeak Morphine"));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(Items.POTION)),Ingredient.fromStacks(new ItemStack(Items.POPPY)),morphinebottle);
        //
        ItemStack musc = new ItemStack(Items.POTION);
        List<EffectInstance> mtrip = new ArrayList<>();
        mtrip.add(new EffectInstance(Effect.get(9), 600,  0, false, false));
        mtrip.add(new EffectInstance(Effect.get(24), 600,  0, false, false));
        mtrip.add(new EffectInstance(Effect.get(16), 600,  0, false, false));
        mtrip.add(new EffectInstance(Effect.get(15), 600,  0, false, false));
        PotionUtils.appendEffects(musc,mtrip);
        musc.getTag().putInt("CustomPotionColor", 7733494);
        musc.setDisplayName(new StringTextComponent("\u00A7RMuscimol"));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(Items.POTION)),Ingredient.fromStacks(new ItemStack(Items.RED_MUSHROOM_BLOCK)),musc);
        //

    }
}
