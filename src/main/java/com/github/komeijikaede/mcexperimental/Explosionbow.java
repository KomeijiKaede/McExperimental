package com.github.komeijikaede.mcexperimental;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
 
@Mod(modid=Explosionbow.MOD_ID, name="SampleItemCore", version="1.0")
public class Explosionbow
{
        public static final String MOD_ID = "SampleItemCore";
	public static Item sampleItem;
 
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//アイテムのインスタンス生成
		sampleItem = new ExplosionSword(ToolMaterial.IRON)
		.setCreativeTab(CreativeTabs.tabCombat)
		.setUnlocalizedName("SampleItem")/*システム名の登録*/
		.setTextureName("samplemod:sample_item")/*テクスチャの指定*/
		/*.setHasSubtypes(true)*//*ダメージ値等で複数の種類のアイテムを分けているかどうか。デフォルトfalse*/
		/*.setMaxDamage(256)*//*耐久値の設定。デフォルト0*/
		/*.setFull3D()*//*３D表示で描画させる。ツールや骨、棒等。*/
		/*.setContainerItem(Items.stick)*//*クラフト時にアイテムを返却できるようにしている際の返却アイテムの指定。*/
		/*.setPotionEffect(PotionHelper.ghastTearEffect)*//*指定文字列に対応した素材として醸造台で使える。PotionHelper参照のこと。*/
		/*.setNoRepair()*//*修理レシピを削除し、金床での修繕を出来なくする*/
		.setMaxStackSize(1);/*スタックできる量。デフォルト64*/
		//アイテムの登録。登録文字列はMOD内で被らなければ何でも良い。
		GameRegistry.registerItem(sampleItem, "sampleItem");
	}
}