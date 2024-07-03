package data;

import net.datafaker.Faker;

public class TarefaDataFactory {
    private static final Faker faker = new Faker();

    public TarefaDataFactory(){
    }
    public static String returnRandomCategoria() {
        return faker.options().option("[Todos os Projetos] categoria teste", "[Todos os Projetos] nova categoria");
    }
    public static String returnRandomFrequencia() {
        return faker.options().option("sempre", "às vezes", "aleatório", "não se tentou", "incapaz de reproduzir","N/D");
    }
    public static String returnRandomGravidade() {
        return faker.options().option("recurso", "trivial", "texto", "mínimo", "pequeno", "grande", "travamento", "obstáculo");
    }
    public static String returnRandomPrioridade() {
        return faker.options().option("nenhuma", "baixa", "normal", "alta", "urgente", "imediato");
    }
    public static String returnRandomResumo(){
        return faker.expression("#{numerify 'NovaTarefa #'}");
    }
    public static String returnRandomDescricao(){
        return faker.expression("#{regexify '[a-z]{10,20}'}");
    }
}
