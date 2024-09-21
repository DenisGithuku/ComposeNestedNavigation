## Compose Nested Navigation
This project is supposed to simulate navigating in compose where there are 
navigation graphs nested inside the main navigation graph.

#### Installation
Clone the app from [repository](https://github.com/DenisGithuku/ComposeNestedNavigation.git).

> **Note**
> This project was set up on Java `17.0.1`, navigation-compose `2.8.1`, compose `1.5.1` and gradle plugin `8.7`

#### The code is structured in the following manner:
``` mermaid 
graph TD 
    B[Main Graph] 
    B-->C((Auth))
    C-->F((Login))
    C-->G((Register))
    B-->D((Home))
    D-->H((Dashboard))
    D-->I((Detail))
    B-->E((Settings)) 
    E-->J((Setting))
    E-->K((Account))
```

The code is very intuitive and everything follows modern design practices.

Feel free to fork for learning or development.