# Biar Mod - Blocks & Items at Runtime

Minecraft [1.12.2]
------
### **This mod is still at the POC stage and is not yet fully complete.** 

### What does this mod do?
This mods purpose is to allow users to add basic blocks & items to Minecraft Forge without any custom code. 

You supply the mod with a zip file containing a json file and some textures.
The json file is used to give the blocks & items their properties.

At launch a ResourcePack.zip is generated with the aforementioned blocks & items. 
The blocks and items are then injected into forge to be used as normal blocks & items. 

**Further documentation comming soon**

### What dosen't this mod do?
 * This mod will **NOT** grant you the ability to add Entities of any kind (yet)
 * You will **NOT** be able to add any advance functionality to the blocks/items (yet)

------

### Zip File Structure 

```
.minecraft/
    |
    |__ biarmod/
        |
        |__ biarmod.zip
            |
            |__biar.json
            |
            |__textures/
                |
                |__items/
                |   |
                |   |__example_item.png
                |
                |__blocks/
                    |
                    |__ example_block.png
```    

### Example JSON Structure
```json
{
  "TABS": [
    {
      "langName" : "Example Tab",
      "unlocalizedName" : "tabExample",
      "icon" : ""
    }
  ],
  "BLOCKS": [
    {
      "langName" : "Example Block",
      "unlocalizedName": "exampleBlock",
      "registryName" : "example_block",
      "tabIndex" : 0,
      "hardness" : 1.5,
      "soundType" : "STONE",
      "material" : "ROCK"
    }
  ],
  "ITEMS": [
    {
      "langName" : "Example Item",
      "unlocalizedName": "exampleItem",
      "registryName" : "example_item",
      "tabIndex" : 0,
      "maxStackSize" : 16
    }
  ]
}
```
