package uk.isohex.voidmachina.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.annotation.Nonnull;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import uk.isohex.voidmachina.core.Common;
import uk.isohex.voidmachina.registry.BlockRegistry;
import uk.isohex.voidmachina.registry.ItemRegistry;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

  public ModRecipeProvider(PackOutput output, CompletableFuture<Provider> registries) {
    super(output, registries);
  }

  @Override
  protected void buildRecipes(@Nonnull RecipeOutput recipeOutput) {
    reversableStorage(ItemRegistry.RAW_VOID_STEEL.get(), BlockRegistry.RAW_VOID_STEEL_BLOCK.get(), recipeOutput);
    reversableStorage(ItemRegistry.VOID_STEEL_INGOT.get(), BlockRegistry.VOID_STEEL_BLOCK.get(), recipeOutput);
    reversableStorage(ItemRegistry.VOID_STEEL_NUGGET.get(), ItemRegistry.VOID_STEEL_INGOT.get(), recipeOutput);

    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.VOID_STEEL_PLATE.get())
        .pattern("##")
        .pattern("##")
        .define('#', ItemRegistry.VOID_STEEL_INGOT.get())
        .unlockedBy(getHasName(ItemRegistry.VOID_STEEL_INGOT.get()), has(ItemRegistry.VOID_STEEL_INGOT.get()))
        .save(recipeOutput);

    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.VOID_CRYSTAL.get())
        .pattern(" # ")
        .pattern("###")
        .pattern(" # ")
        .define('#', ItemRegistry.CRACKED_VOID_CRYSTAL.get())
        .unlockedBy(getHasName(ItemRegistry.CRACKED_VOID_CRYSTAL.get()), has(ItemRegistry.CRACKED_VOID_CRYSTAL.get()))
        .save(recipeOutput);

    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistry.CRACKED_VOID_CRYSTAL.get(), 5)
        .requires(ItemRegistry.VOID_CRYSTAL.get())
        .unlockedBy(getHasName(ItemRegistry.VOID_CRYSTAL.get()), has(ItemRegistry.VOID_CRYSTAL.get()))
        .save(recipeOutput, Common.MODID + ":" + getItemName(ItemRegistry.CRACKED_VOID_CRYSTAL.get()) + "_from_"
            + getItemName(ItemRegistry.VOID_CRYSTAL.get()));

    List<ItemLike> rawVoidSteelSmeltables = List.of(ItemRegistry.RAW_VOID_STEEL, BlockRegistry.VOID_STEEL_ORE);

    oreSmelting(recipeOutput, rawVoidSteelSmeltables, RecipeCategory.MISC, ItemRegistry.VOID_STEEL_INGOT.get(), 0.25f,
        200, "void_steel");
    oreBlasting(recipeOutput, rawVoidSteelSmeltables, RecipeCategory.MISC, ItemRegistry.VOID_STEEL_INGOT.get(), 0.25f,
        100, "void_steel");
  }

  protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category,
      ItemLike result, float experience, int cookingTime, String group) {
    oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, ingredients, category, result,
        experience, cookingTime, group, "_from_smelting");
  }

  protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category,
      ItemLike result, float experience, int cookingTime, String group) {
    oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, ingredients, category, result,
        experience, cookingTime, group, "_from_blasting");
  }

  // I've overriden the base class version of this to add the Void Machina modid
  // to the recipe names
  protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput,
      RecipeSerializer<T> serializer, AbstractCookingRecipe.Factory<T> recipeFactory, List<ItemLike> ingredients,
      RecipeCategory category, ItemLike result, float experience, int cookingTime, String group, String suffix) {
    for (ItemLike itemLike : ingredients) {
      SimpleCookingRecipeBuilder
          .generic(Ingredient.of(new ItemLike[] { itemLike }), category, result, experience, cookingTime, serializer,
              recipeFactory)
          .group(group).unlockedBy(getHasName(itemLike), has(itemLike))
          .save(recipeOutput, Common.MODID + ":" + getItemName(result) + suffix + "_" + getItemName(itemLike));
    }
  }

  protected static void reversableStorage(ItemLike item, ItemLike block, @Nonnull RecipeOutput recipeOutput) {
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, block)
        .pattern("###")
        .pattern("###")
        .pattern("###")
        .define('#', item)
        .unlockedBy(getHasName(item), has(item))
        .save(recipeOutput, Common.MODID + ":" + getItemName(block) + "_from_" + getItemName(item));

    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, item, 9)
        .requires(block)
        .unlockedBy(getHasName(block), has(block))
        .save(recipeOutput, Common.MODID + ":" + getItemName(item) + "_from_" + getItemName(block));
  }
}
