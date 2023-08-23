package com.care.project.shop;

public class CartItemDTO {
    private ShopDTO product; // 상품 정보
    private int quantity;    // 수량

    public CartItemDTO(ShopDTO product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ShopDTO getProduct() {
        return product;
    }

    public void setProduct(ShopDTO product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}