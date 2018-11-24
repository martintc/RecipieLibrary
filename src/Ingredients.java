

public class Ingredients {

    private String quantity;
    private String ingredientName;

    public Ingredients (String pQuantity, String pIngredientName) {
        quantity = pQuantity;
        ingredientName = pIngredientName;
    }

    public void setQuantity (String pQuantity) {
        quantity = pQuantity;
    }

    public void setIngredientName (String pIngredientName) {
        ingredientName = pIngredientName;
    }

    public String getQuantity () {
        return quantity;
    }

    public String getIngredientName () {
        return ingredientName;
    }

}
