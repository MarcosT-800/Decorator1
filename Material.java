// Material.java
package aula;

public interface Material {
    String obterDescricao();
    double obterCusto();
}

// Romance.java
package aula;

public class Romance implements Material {
    @Override
    public String obterDescricao() {
        return "Romance";
    }

    @Override
    public double obterCusto() {
        return 10.0; // Custo base do romance
    }
}

// Dicionario.java
package aula;

public class Dicionario implements Material {
    @Override
    public String obterDescricao() {
        return "Dicionário";
    }

    @Override
    public double obterCusto() {
        return 15.0; // Custo base do dicionário
    }
}

// MaterialDecorator.java
package aula;

public abstract class MaterialDecorator implements Material {
    protected Material material;

    public MaterialDecorator(Material material) {
        this.material = material;
    }

    @Override
    public String obterDescricao() {
        return material.obterDescricao();
    }

    @Override
    public double obterCusto() {
        return material.obterCusto();
    }
}

// EmprestimoDecorator.java
package aula;

public class EmprestimoDecorator extends MaterialDecorator {
    public EmprestimoDecorator(Material material) {
        super(material);
    }

    @Override
    public String obterDescricao() {
        return super.obterDescricao() + " (empréstimo)";
    }

    @Override
    public double obterCusto() {
        return super.obterCusto() + 2.0; // Custo adicional para empréstimo
    }
}

// ReservaDecorator.java
package aula;

public class ReservaDecorator extends MaterialDecorator {
    public ReservaDecorator(Material material) {
        super(material);
    }

    @Override
    public String obterDescricao() {
        return super.obterDescricao() + " (reserva)";
    }

    @Override
    public double obterCusto() {
        return super.obterCusto() + 1.0; // Custo adicional para reserva
    }
}

// ExemploDecorator.java
package aula;

public class ExemploDecorator {
    public static void main(String[] args) {
        Material romance = new Romance();
        Material dicionario = new Dicionario();

        // Adicionando funcionalidades de empréstimo
        romance = new EmprestimoDecorator(romance);
        dicionario = new ReservaDecorator(dicionario);

        // Exibindo as descrições e custos
        System.out.println("Material: " + romance.obterDescricao());
        System.out.println("Custo total: R$ " + romance.obterCusto());

        System.out.println("Material: " + dicionario.obterDescricao());
        System.out.println("Custo total: R$ " + dicionario.obterCusto());
    }
}
