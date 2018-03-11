
\## ViewPager Delegate  
  
Está es la implementación de un \`viewpager\` que maneja múltiples layouts. Su adapter contiene diversos \`delegates\` que según un \`viewType\` se encargarán de renderizar el layout correspondiente.  
  
La intención principal de hacer esto es la de simplificar el manejo múltiples vistas utilizando componentes desacoplados del adapter general.  
  
Por cada tipo de vista se debe generar un delegate  
  
Ejemplo:  
```java  
 public class SimpleImageDelegate extends  ViewPagerDelegate<ContentVM> {            
         
         public static final int DELEGATE_TYPE = 64;    
            
         @Override    
          public int getDelegateType() {    
                return DELEGATE_TYPE;    
          }    
            
            @Override    
          public boolean isForViewType(@NonNull List<ContentVM> items, int position) {    
                return items.get(position).getViewType() == DELEGATE_TYPE;    
          }    
            
            @Override    
          public Object instantiateItem(List<ContentVM> items, ViewGroup container, int position) {    
                LayoutInflater inflater = (LayoutInflater) container.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
                View itemView = inflater.inflate(R.layout.item_simple_image_view, container, false);  
                container.addView(itemView);  
                return itemView;  
          }  
 }
 ```