spark-template-velocity 
==============================================

How to use the Apache Velocity template route for Spark example:

```java
import static spark.Spark.get;

import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityRoute;

/**
 * VelocityTemplateRoute example.
 */
public final class VelocityExample {
    
	public static void main(final String[] args) {
        
        get(new VelocityRoute("/hello") {
            @Override
            public Object handle(final Request request, final Response response) {
                Map<String, Object> model = new HashMap<String, Object>();
                model.put("hello", "Velocity World");
                
                // The wm files are located under the resources directory
                return modelAndView(model, "hello.wm");
            }
        });
        
    }
}
```
