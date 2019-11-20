package edu.mum.ishop.customTag;
import edu.mum.ishop.dao.DataAccessManager;
import edu.mum.ishop.model.OrderLine;
import edu.mum.ishop.model.Product;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringReader;


public class CartItemTag extends SimpleTagSupport {


    public OrderLine getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(OrderLine orderLine) {
        this.orderLine = orderLine;
    }

    private OrderLine orderLine;


    @Override
    public void doTag() throws JspException, IOException {

         DataAccessManager da=new DataAccessManager();
         Product product= da.Product_SelectOne(orderLine.getProductId());

        StringBuilder sb = new StringBuilder();

        sb.append("<div class='card border-info mb-3'>");
        sb.append("<div class='card-header row'>");
        sb.append("<div class='col-4'>");
        //sb.append("<i class='prd-lbl'>Price</i><i>15.55$</i>");
        sb.append(String.format("<i class='prd-lbl'>Price</i><i>%s $</i>",orderLine.getUnitPrice()));
        sb.append("</div>");
        sb.append("<div class='col-6'>");
        //sb.append("<i class='prd-lbl'>Quantity</i> <i>2</i>");
        sb.append(String.format("<i class='prd-lbl'>Quantity</i> <i>%s</i>",orderLine.getQuantity()));
        sb.append("</div>");
        sb.append("<div class='col-2'>");
        //sb.append("<i class='prd-lbl'>Sum</i> <i>30.00$</i>");
        sb.append(String.format("<i class='prd-lbl'>Sum</i> <i>%s$</i>",orderLine.getQuantity()*orderLine.getUnitPrice()));

        sb.append("</div>");
        sb.append("</div>");
        sb.append("<div class='card-body row'>");
        //sb.append("<img src='imgs/p1.JPG' class='cart-prd-img col-3'>");
        sb.append(String.format("<img src='%s' class='cart-prd-img col-3'>",product.getImageUrl()));
        sb.append("<div class='col-9'>");
        //sb.append("<h4 class='card-title'>Product Name</h4>");
        sb.append(String.format("<h4 class='card-title'>%s</h4>",product.getProductName()));

        //sb.append("<p class='card-text'>Description Some quick example text to build on the card title and make up the bulk of the card's content.</p>");
        sb.append(String.format("<p class='card-text'>%s.</p>",product.getDescription()));
        sb.append("</div>");
        sb.append("</div>");
        sb.append("</div>");

        JspWriter jspWriter = getJspContext().getOut();
        jspWriter.append(sb.toString());
    }


}
