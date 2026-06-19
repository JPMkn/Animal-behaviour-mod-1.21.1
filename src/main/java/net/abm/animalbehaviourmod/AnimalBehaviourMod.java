package net.abm.animalbehaviourmod;


import com.mojang.logging.LogUtils;
//import net.abm.animalbehaviourmod.event.EntityEvents;
import net.neoforged.bus.api.IEventBus;
//import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
//import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(AnimalBehaviourMod.MODID)
public class AnimalBehaviourMod {
    public static final String MODID = "animalbehaviourmod";
    public static final Logger LOGGER = LogUtils.getLogger();
    //public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    //public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    //public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

/*
    public static final DeferredBlock<Block> EXAMPLE_BLOCK = BLOCKS.registerSimpleBlock("example_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));
    // Creates a new BlockItem with the id "animalbehaviourmod:example_block", combining the namespace and path
    public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("example_block", EXAMPLE_BLOCK);
    // Creates a new food item with the id "animalbehaviourmod:example_id", nutrition 1 and saturation 2
    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(2f).build()));

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.animalbehaviourmod")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(EXAMPLE_ITEM.get()); // Add the abm item to the tab. For your own tabs, this method is preferred over the event
            }).build());
 */
/*
    public AnimalBehaviourMod(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        //NeoForge.EVENT_BUS.register(EntityEvents.class);
        //ABMDataComponents.register(modEventBus);
        //ABMtems.register(modEventBus);
        //ABMEntities.register(modEventBus);
        //ABMEntityEvents.register(modEventBus);
        //ABMBlockEntities.register(modEventBus);
        //ABMMenuTypes.register(modEventBus);
        //ABMRecipes.register(modEventBus);
        //BLOCKS.register(modEventBus);
        //ITEMS.register(modEventBus);
        //CREATIVE_MODE_TABS.register(modEventBus);
        //modEventBus.addListener(this::addCreative);

    }
    private void commonSetup(FMLCommonSetupEvent event) {

    }

    /*
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {

        }
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){

        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

     */

}
