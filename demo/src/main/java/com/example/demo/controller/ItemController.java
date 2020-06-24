package com.example.demo.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Item;
import com.example.demo.factory.FactoryForTypeService;
import com.example.demo.service.ItemService;
import com.example.demo.util.JsonXMLUtils;
import com.example.demo.util.Msg;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class ItemController {

    @Resource
    private ItemService itemService;

    @Resource
    private FactoryForTypeService factoryForTypeService;


    /**
     * @Description: 添加新的商品
     * @Param: [item]
     * @returns: com.example.demo.entity.Item
     * @Author: Exgc
     * @Date: 2020/6/15 5:31
     * TODO:此处应该处理为商品和拍卖两个表同时进行处理
     */
    @PostMapping("/addItem")
    public Msg addItem(@RequestBody Item item){
        System.out.println(item.toString());
        return itemService.addItem(item);
    }

    /**
     * @Description: 根据商品编号查询商品信息
     * @Param: [itemId]
     * @returns: com.example.demo.entity.Item
     * @Author: Exgc
     * @Date: 2020/6/15 5:29
     */
    @RequestMapping("/getItemById/{itemId}")
    public JSONObject getItemById(@PathVariable int itemId){
        return itemService.getItemById(itemId);
    }

    /**
     * @Description: 更新商品信息
     * @Param: [item]
     * @returns: com.example.demo.entity.Item
     * @Author: Exgc
     * @Date: 2020/6/15 12:35
     */
    @RequestMapping("/updateItem")
    public Msg updateItem(@RequestBody Item item){
        return itemService.updateItem(item);
    }


    /**
     * @Description: 删除对应商品信息
     * @Param: [itemId]
     * @returns: boolean
     * @Author: Exgc
     * @Date: 2020/6/15 20:57
     * 删除后，商品状态切换为2，数据不删除
     */
    @RequestMapping("/deleteItem/{itemId}")
    public Msg deleteItemById(@PathVariable int itemId){
        return itemService.deleteItemById(itemId);
    }


    /**
     * @Description:
     * @Param: []
     * @returns: java.util.List<com.example.demo.entity.Item>
     * @Author: Exgc
     * @Date: 2020/6/16 1:31
     */
    @RequestMapping("/itemList")
    public List<JSONObject> getItemList(){
        return itemService.getItemList();
    }


    @RequestMapping("/addItemType/{key}")
    public Msg addItemType(@PathVariable String key,@RequestBody Map<String,Object> map) throws Exception {
        Item item=JsonXMLUtils.map2obj((Map<String, Object>) map.get("item"),Item.class);
        JSONObject jsonObject= JsonXMLUtils.map2obj((Map<String, Object>) map.get("type"),JSONObject.class);
        try {
            Msg msg=itemService.addItem(item);
            jsonObject.put("itemId",msg.getObj());
            factoryForTypeService.getTypeService(key).addType(jsonObject);
            return new Msg<>(0,"success",msg.getObj());
        }catch (Exception e){
            return Msg.err(e.toString());
        }
    }




}
