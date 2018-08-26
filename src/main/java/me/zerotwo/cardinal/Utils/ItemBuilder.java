package me.zerotwo.cardinal.Utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.Arrays;

public class ItemBuilder {
    private ItemStack itemStack;
    private ItemMeta itemMeta;
    public ItemBuilder(Material type){
        this.itemStack=new ItemStack(type);
        this.itemMeta=itemStack.getItemMeta();
    }

    public ItemBuilder type(Material type){
        this.itemStack.setType(type);
        return this;
    }
    public ItemBuilder amount(int newAmount){
        this.itemStack.setAmount(newAmount);
        return this;
    }
    public ItemBuilder name(String displayName){
        this.itemMeta.setDisplayName(displayName);
        return this;
    }
    public ItemBuilder lore(String... lore){
        this.itemMeta.setLore(Arrays.asList(lore));
        return this;
    }
    public ItemBuilder byteData(short newData){
        this.itemStack.setDurability(newData);
        return this;
    }
    public ItemBuilder materialData(MaterialData materialData){
        this.itemStack.setData(materialData);
        return this;
    }
    public ItemBuilder unbreakable(boolean unbreakable){
        this.itemMeta.setUnbreakable(unbreakable);
        return this;
    }
    public ItemStack make(){
        this.itemStack.setItemMeta(itemMeta);
        return this.itemStack;
    }
}