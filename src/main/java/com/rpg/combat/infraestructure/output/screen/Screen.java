package com.rpg.combat.infraestructure.output.screen;

import com.rpg.combat.domain.models.TemplateTag;

import java.util.List;

public interface Screen {

    // template de la pantalla, incluyendo las etiquetas que seran reemplazadas por replaceTemplateTags(tags)
    // ej:
    // <nombreDelPersonaje>
    // se reemplaza el tag nombreDelPersonaje dentro de replaceTemplateTags(List<TemplateTags> tags)
    // Clase: " + nombreDelPersonaje
    String[] getTemplate();

    // Muestra la pantalla final con las etiquetas reemplazados con el texto
    void show();

   /* // Reemplaza tags dentro de
    default String[] replaceTemplateTags(List<TemplateTag> tags){
        String[] processedTemplate = getTemplate();
        // Reemplazar cada etiqueta en la línea
        for (TemplateTag tag : tags) {
            for (String line : getTemplate()) {
                if(line.contains(tag.getKey())){
                    // reemplazar tag de processedTemplate por el String[] que devuelve tag.getValues()
                }
            }
        }
        return processedTemplate;
    }*/

    default String[] replaceTemplateTags(List<TemplateTag> tags) {
        String[] processedTemplate = getTemplate().clone(); // Clonar para evitar modificar el original
        // Iterar sobre cada etiqueta a reemplazar
        for (TemplateTag tag : tags) {
            String key = tag.getKey();
            String[] values = tag.getTemplateValue();
            // Iterar sobre cada línea del template
            for (int i = 0; i < processedTemplate.length; i++) {
                if (processedTemplate[i].contains(key)) {
                    // Concatenar los valores de la etiqueta en una sola línea si hay múltiples
                    processedTemplate[i] = processedTemplate[i].replace(key, String.join(" ", values));
                }
            }
        }
        return processedTemplate;
    }

    
    /*
       simple

         "<nombreDelPersonaje>"
         " Clase: " + nombreDelPersonaje

       multiple

        "<Enemigos>"
        " Enemigo1: " + nombreDelEnemigo1
        " HP: " + hpEnemigo1
        ""
        " Enemigo2: " + nombreDelEnemigo2
        " HP: " + hpEnemigo2
        ""
     * 
     * 
     * 
     * 
    * */
}
