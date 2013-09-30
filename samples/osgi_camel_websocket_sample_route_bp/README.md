This bundle uses websocket servlet service published by
osgi_camel_websocket_service_bp
and implements a scenario having two routes using Bluepring: 
the first one greets to the caller and the second one greets to 
everyone.

        <route>
            <from uri="websocket2:///hola"/>
            <process ref="websocketProcessor"/>
            <to uri="websocket2:///hola"/>
        </route>
        <route>
            <from uri="websocket2:///hola2"/>
            <process ref="websocketProcessor"/>
            <to uri="websocket2:///hola2?sendToAll=true"/>
        </route>

The first route is hosted at
  http://localhost:8181/camel/websockets/hola 
and the second route at 
  http://localhost:8181/camel/websockets/hola2








