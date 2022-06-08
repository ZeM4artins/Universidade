import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CasaInteligente {

    Map<String,SmartDevice> dispositivos_Casa; //id e dispositivo
    Map<String, List<SmartDevice>> dispositivos_divisao_Casa; // nome da divisão e lista de equipamentos lá existentes

    public CasaInteligente () {
        this.dispositivos_Casa = new HashMap<>();
        this.dispositivos_divisao_Casa = new HashMap<>();
    }

    public CasaInteligente (Collection<SmartDevice> devices) {
        for (SmartDevice s1 : devices) {
            this.dispositivos_Casa.put(s1.getId(),s1);
        }
    }

    public void remove(String id) throws Disp_Inexistente {
        if (this.dispositivos_Casa.get(id)!=null) {
            this.dispositivos_Casa.remove(id);
        }
        else throw new Disp_Inexistente(id);
        System.out.println(this.dispositivos_Casa);
    }

    public Iterator<SmartDevice> devicesPorConsumoCrescente() {
        return this.dispositivos_Casa.values().stream().sorted(Comparator.comparing(SmartDevice::getConsumoPorHora)).iterator();
    }


    public int consumoTot (String s) {
        return (int)this.dispositivos_divisao_Casa.get(s).stream().mapToDouble(SmartDevice::totalConsumo).count();

    }

    public String divisaoMaisEconomica() {
        int menor_consumo = 100000;
        String menor_consumidora = new String();
        for (String s : this.dispositivos_divisao_Casa.keySet()) {
            if (menor_consumo>consumoTot(s)) {
                menor_consumidora = s;
                menor_consumo = consumoTot(s);
            }
        }
        System.out.println(menor_consumidora);
        return menor_consumidora;
    }


    public boolean apenasNumaDivisao() {
        int devices = (int)this.dispositivos_Casa.values().stream().distinct().count();
        int devices_divisoes = 0;
        for (List<SmartDevice> list: this.dispositivos_divisao_Casa.values()) {
            for (SmartDevice sm : list) {
                devices_divisoes++;
            }
        }
        System.out.println(devices_divisoes==devices);
        return ((devices==devices_divisoes));
    }

    public boolean gravaEmFichObjectos(String fich) throws FileNotFoundException, IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fich));
        for (SmartDevice sm : this.dispositivos_Casa.values()) {
            if (sm instanceof SmartSpeaker) {
                try {
                    oos.writeObject(sm);
                } catch (IOException ioe) {
                    throw new RuntimeException();
                }
            }

        }
        oos.flush();
        oos.close();
        return true;
    }


    @Override
    public String toString() {
        return "CasaInteligente{" +
                "dispositivos_Casa=" + dispositivos_Casa +
                ", dispositivos_divisao_Casa=" + dispositivos_divisao_Casa +
                '}';
    }

    public static void main(String[] args) throws Disp_Inexistente {
        CasaInteligente c1 = new CasaInteligente();
        SmartDevice s1 = new SmartDevice();
        SmartBulb b1 = new SmartBulb();
        SmartSpeaker ss1 = new SmartSpeaker();

        ss1.setId("Smart Speaker 1");
        ss1.setConsumoPorHora(10);

        b1.setId("Smart Bulb 1");
        b1.setConsumoPorHora(20);

        c1.dispositivos_Casa.put(ss1.getId(),ss1);
        c1.dispositivos_Casa.put(b1.getId(),b1);

        List<SmartDevice> Sala = new ArrayList<>();
        List<SmartDevice> Cozinha = new ArrayList<>();
        Sala.add(ss1);
        //Cozinha.add(ss1);
        Cozinha.add(b1);

        c1.dispositivos_divisao_Casa.put("Sala",Sala);
        c1.dispositivos_divisao_Casa.put("Cozinha",Cozinha);

        c1.apenasNumaDivisao();

    }
}
