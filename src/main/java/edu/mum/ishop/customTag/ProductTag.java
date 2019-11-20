package edu.mum.ishop.customTag;
import edu.mum.ishop.model.Product;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringReader;

public class ProductTag extends SimpleTagSupport {
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    private Product product;


    @Override
    public void doTag() throws JspException, IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("<div class='col-xs-12 col-md-4 h-50 product-box-lg'>");
        sb.append("<div class='img-box'>");
        //sb.append("<img src='imgs/p1.JPG' class='prd-img-lg'>");
        sb.append(String.format("<img src='%s' class='prd-img-lg'>",product.getImageUrl()));
        sb.append("<div class='brd img-box-p r-btm-5 shw-hdn'>");
        //sb.append("<div class='head-text'>Islander seek shelter from Hurricane Irma</div>");
        sb.append(String.format( "<div class='head-text'>%s</div>",product.getProductName()));
        sb.append("<div class='details-text'></div>");
        sb.append("<div class='bottom-text red-l-b'>");
        //sb.append("<div class='float-left'>LATIN AMERICA & CARIBBEAN</div>");
        sb.append(String.format("<div class='float-left'>%s</div>",product.getDescription()));
        sb.append(String.format("<div class='float-left'>%s</div>",product.getPrice()));
        sb.append("<button type='button' class='btn btn-outline-primary float-right mr-1'>Add To Cart</button>");
        sb.append("</div>");
        sb.append("</div>");
        sb.append("</div>");
        sb.append("</div>");


        /*if(color == null && size == null) {
            sb.append("<span>");
        } else {
            sb.append("<span style=\"");
            if (color != null) {
                sb.append(String.format("color: %s;", color));
            }
            if (size != null) {
                sb.append(String.format("font-size: %s;", size));
            }
            sb.append("\">");
        }
        sb.append(currDate);
        sb.append("</span>");*/
        JspWriter jspWriter = getJspContext().getOut();
        jspWriter.append(sb.toString());
    }


}
