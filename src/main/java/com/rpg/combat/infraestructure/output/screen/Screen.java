package com.rpg.combat.infraestructure.output.screen;

import com.rpg.combat.domain.models.OptionScreen;
import com.rpg.combat.domain.models.TemplateTag;

import java.util.List;

public interface Screen {

    // Plantilla o prototipo para la pantalla
    String[] getTemplate();

    // Muestra la pantalla final con las etiquetas reemplazados con el texto
    void show();

    // Devolver Opciones a mostrar en ConsoleUI
    OptionScreen getOptions();

    default String[] replaceTemplateTags(List<TemplateTag> tags) {
        return replaceTemplateTags(tags, getTemplate());
    }

    default String[] replaceTemplateTags(List<TemplateTag> tags, String[] template) {

        // Clonar para evitar modificar el original
        // TODO: RECIBIR GETTEMPLADE
        String[] processedTemplate = template.clone();
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

}
