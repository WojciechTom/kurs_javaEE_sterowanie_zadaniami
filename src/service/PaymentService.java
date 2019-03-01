package service;

import model.CartItem;
import java.util.List;

public class PaymentService {

    private static final double PRICE_TO_DISCOUNT = 100;
    private static final String DISCOUNT_BRAND = "adidas";


    public static void applyDiscounts(List<CartItem> items){
        standardDiscount(items);
        adidasDiscount(items);
    }

    private static void adidasDiscount(List<CartItem> items) {

        for (CartItem f: items) {
            System.out.println(f.toString() + "discount");
        }
        items.stream().filter(item->item.getProduct().toLowerCase().contains(DISCOUNT_BRAND)).forEach(PaymentService::adidasDiscountForItem);
    }


    private static void adidasDiscountForItem(CartItem item) {
        double priceToDiscount;
        if(item.getDiscountPrice()!=0){
            priceToDiscount = item.getDiscountPrice();
        } else {
            priceToDiscount = item.getOriginalPrice();
            item.setDiscountPrice(priceToDiscount*0.8);
        }
    }

    private static void standardDiscount(List<CartItem> items) {
        if(totalPrice(items) > PRICE_TO_DISCOUNT){
            items.forEach(item->item.setDiscountPrice(item.getOriginalPrice()*0.9));
        } else {
            items.forEach(item->item.setDiscountPrice(item.getOriginalPrice()));
        }
    }


    public static double totalPrice(List<CartItem> items){
        return items.stream().mapToDouble(CartItem::getOriginalPrice).sum();
    }

    public static double totalPriceAfterDiscount(List<CartItem> items){
        return items.stream().mapToDouble(CartItem::getDiscountPrice).sum();
    }

}
