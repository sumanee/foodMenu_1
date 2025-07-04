package com.promotion.food.controller;

import com.promotion.food.dto.MapPromotionResponseDto;
import com.promotion.food.dto.TypeMenuDto;
import com.promotion.food.enity.MapPromotion;
import com.promotion.food.enity.Promotion;
import com.promotion.food.enity.TypeFood;
import com.promotion.food.enity.TypeMenu;
import com.promotion.food.repository.PromotionRepository;
import com.promotion.food.service.MapPromotionService;
import com.promotion.food.service.PromotionService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/promotion")
@AllArgsConstructor
public class PromotionController {
    private PromotionService promotionService;
private MapPromotionService mapPromotionService;
    @PostMapping
    public ResponseEntity<Promotion> createPromotion(@RequestBody Promotion dataPromotion){
        Promotion pomotion = promotionService.createPromotion(dataPromotion);
        return new ResponseEntity<>(pomotion, HttpStatus.CREATED);

    }

    @PostMapping("/map")
    public ResponseEntity<MapPromotionResponseDto> createMapPromotion(@RequestBody MapPromotionResponseDto dataMapPromotionResponseDto){
        System.out.println("dataMapPromotionResponseDto"+dataMapPromotionResponseDto);
        MapPromotion mapPromotion = mapPromotionService.createMapPromotion(dataMapPromotionResponseDto);
        System.out.println("MapPromotion = "+mapPromotion);
        System.out.println("getPromotion = "+mapPromotion.getPromotion());
        System.out.println("getTypeFood = "+mapPromotion.getTypeFood());
        System.out.println("getTypeMenu = "+mapPromotion.getTypeMenu());
        MapPromotionResponseDto mapPromotionResponseDto = new MapPromotionResponseDto();
        mapPromotionResponseDto.setMapPromotionId(mapPromotion.getMapPromotionId());
        mapPromotionResponseDto.setPromotionId(mapPromotion.getPromotion().getPromotionId());
        mapPromotionResponseDto.setTypeMenuId(mapPromotion.getTypeMenu().getTypeMenuId());
        mapPromotionResponseDto.setTypeFoodId(mapPromotion.getTypeFood().getTypeFoodId());
        mapPromotionResponseDto.setPromotion(mapPromotion.getPromotion());
        mapPromotionResponseDto.setTypeMenu(mapPromotion.getTypeMenu());
        mapPromotionResponseDto.setTypeFood(mapPromotion.getTypeFood());

        return new ResponseEntity<>(mapPromotionResponseDto, HttpStatus.CREATED);


    }

    @GetMapping("/map")
    public ResponseEntity<List<MapPromotionResponseDto.PromotionPayloadDto>> getMapPromotionByPromotionId(@RequestParam Long id ){

        List<MapPromotion> mapPromotionList = mapPromotionService.getMapPromotionByPromotionId(id);
        System.out.println("mapPromotionList" + mapPromotionList);
        // ดึงชื่อโปรโมชั่นจากรายการแรก
        String promotionName = mapPromotionList.get(0).getPromotion().getPromotionName();


        // ดึงชื่อเมนูจากรายการแรก
        Map<Long, List<MapPromotion>> groupedMenu = mapPromotionList.stream()
                .collect(Collectors.groupingBy(mp -> mp.getTypeMenu().getTypeMenuId()));
        System.out.println("groupedMenu" + groupedMenu);

        List<MapPromotionResponseDto.TypeMenuDto> typeMenuList = groupedMenu.entrySet().stream()
                .map(entry -> {
                   // Long typeMenuId = entry.getKey();
                    List<MapPromotion> items = entry.getValue();

                    String typeMenuName = items.get(0).getTypeMenu().getTypeMenuName();
                    List<MapPromotionResponseDto.TypeFoodDto> typeFoodList = items.stream()
                            .map(mp -> new MapPromotionResponseDto.TypeFoodDto(mp.getTypeFood().getNameTypeFood()))
                            .toList();

                    return new MapPromotionResponseDto.TypeMenuDto(typeMenuName, typeFoodList);
                })
                .toList();

        MapPromotionResponseDto.PromotionPayloadDto response =
                new MapPromotionResponseDto.PromotionPayloadDto(promotionName, typeMenuList);

        List<MapPromotionResponseDto.PromotionPayloadDto> mapPromotionResponseDtoList = new ArrayList<>();
        mapPromotionResponseDtoList.add(response);

        //groupedMenu{
        // 1=[
        // MapPromotion(
        // mapPromotionId=2, isActivate=true, promotion=Promotion(promotionId=1, promotionName=Promotion A, activate=true),
        // typeMenu=TypeMenu{typeMenuId=1, typeMenuName='Breakfast-E', getActivate=true},
        // typeFood=TypeFood(typeFoodId=2, nameTypeFood=Fried egg, activate=true)),
        // MapPromotion(
        // mapPromotionId=3, isActivate=true, promotion=Promotion(promotionId=1, promotionName=Promotion A, activate=true),
        // typeMenu=TypeMenu{typeMenuId=1, typeMenuName='Breakfast-E', getActivate=true},
        // typeFood=TypeFood(typeFoodId=3, nameTypeFood=Bacon, activate=true))],
        //
        // 2=[MapPromotion(
        // mapPromotionId=13, isActivate=true, promotion=Promotion(promotionId=1, promotionName=Promotion A, activate=true),
        // typeMenu=TypeMenu{typeMenuId=2, typeMenuName='Lunch-E', getActivate=true},
        // typeFood=TypeFood(typeFoodId=4, nameTypeFood=Seafood, activate=true))]}


       // mapPromotionList[
        // MapPromotion(
        // mapPromotionId=2, isActivate=true,
        // promotion=Promotion(promotionId=1, promotionName=Promotion A, activate=true),
        // typeMenu=TypeMenu{typeMenuId=1, typeMenuName='Breakfast-E', getActivate=true},
        // typeFood=TypeFood(typeFoodId=2, nameTypeFood=Fried egg, activate=true)),
        //
        // MapPromotion(mapPromotionId=3, isActivate=true, promotion=Promotion(promotionId=1,
        // promotionName=Promotion A, activate=true),
        // typeMenu=TypeMenu{typeMenuId=1, typeMenuName='Breakfast-E', getActivate=true},
        // typeFood=TypeFood(typeFoodId=3, nameTypeFood=Bacon, activate=true))]


        /*
        * {
        *promotionName "Promotion A"
        * typeMenu : [
        * *{
        * *typeMenuName :'Breakfast-E',
        * *typeFood : [
        * *{
        * *
        * * nameTypeFood : Bacon
        * *},
        * *{
        * *
        * *nameTypeFood=Fried egg
        * *}
        * *
        * *]
        * *}
        * ]
        * }
        * **/


        return new ResponseEntity<>(mapPromotionResponseDtoList,HttpStatus.OK);
    }




}
