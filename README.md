# Biart Mod - Blocks & Items at Runtime

### **This mod is still at the POC stage and is not yet fully complete.** 


### What does this mod do?
This mods purpose is to allow users to add basic blocks & items to Minecraft Forge without any custom code. 

By updating the `biartmod/biart.json` file you can add blocks & items at runtime.

### What doesn't this mod do?
 * This mod will **NOT** grant you the ability to add Entities of any kind (yet)
 * You will **NOT** be able to add any advance functionality to the blocks/items (yet)


### Example JSON
```json
{
  "TABS": [
    {
      "langName" : "Example",
      "icon" : "minecraft:block/dirt"
    }
  ],
  "BLOCKS": [
    {
      "langName" : "Example Block",
      "unlocalizedName": "exampleBlock",
      "registryName" : "example_block"
    }
  ],
  "ITEMS": [
    {
      "langName" : "Example Item",
      "unlocalizedName": "exampleItem",
      "registryName" : "example_item"
    }
  ]
}
```