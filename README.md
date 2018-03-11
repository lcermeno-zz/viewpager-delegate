
## ViewPager Delegate  
  
Está es la implementación de un `viewpager` que maneja múltiples layouts. Su adapter contiene diversos `delegates` que según un `viewType` se encargarán de renderizar el layout correspondiente.  
  
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
 
 public class QiuboPagerAdapter extends PagerAdapter {  
  
     private List<ContentVM> mItems;  
     private ViewPagerDelegateManager<ContentVM> mDelegateManager;  
      
     public QiuboPagerAdapter() {  
          mDelegateManager = new ViewPagerDelegateManager<>();  
          mDelegateManager.addDelegate(new SimpleImageDelegate());  
          mDelegateManager.addDelegate(new SimpleTextViewDelegate());  
          mDelegateManager.addDelegate(new SimpleButtonDelegate());  
      }  
      
      @Override  
      public int getCount() {  
            return mItems != null ? mItems.size() : 0;  
      }  
      
      @Override  
      public boolean isViewFromObject(View view, Object object) {  
            return view == object;  
      }  
      
      @Override  
      public Object instantiateItem(ViewGroup container, int position) {  
            return mDelegateManager.instantiateItem(mItems, container, position);  
      }  
      
      @Override  
      public void destroyItem(ViewGroup container, int position, Object object) {  
          mDelegateManager.destroyViewHolder(position);  
          container.removeView((View) object);  
      }  
      
      public void setItems(List<ContentVM> items) {  
          mItems = items;  
          notifyDataSetChanged();  
      }  
}
 ``