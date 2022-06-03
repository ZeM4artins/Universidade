public class LinhaDeEncomenda {

    private String referencia;
    private String descricao;
    private double precoProduto; //antes dos impostos
    private int quantidadeEnc;
    private double imposto;
    private double descontoComercial;

    public LinhaDeEncomenda() {
        this.referencia = "";
        this.descricao = "";
        this.precoProduto = 0;
        this.quantidadeEnc=0;
        this.imposto=0;
        this.descontoComercial=0;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public int getQuantidadeEnc() {
        return quantidadeEnc;
    }

    public void setQuantidadeEnc(int quantidadeEnc) {
        this.quantidadeEnc = quantidadeEnc;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public double getDescontoComercial() {
        return descontoComercial;
    }

    public void setDescontoComercial(double descontoComercial) {
        this.descontoComercial = descontoComercial;
    }

    public LinhaDeEncomenda(LinhaDeEncomenda linha) {
        this.referencia = linha.getReferencia();
        this.descricao = linha.getDescricao();
        this.precoProduto = linha.getPrecoProduto();
        this.quantidadeEnc = linha.getQuantidadeEnc();
        this.imposto = linha.getImposto();
        this.descontoComercial = linha.getDescontoComercial();
    }

    public double calculaValorLinhaEnc() {
        return (1+(this.imposto-this.descontoComercial)/100)*this.precoProduto;
    }

    public double calculaValorDesconto() {
        return this.descontoComercial/100 * this.precoProduto;
    }

    public boolean equals(Object o) {
        if (this == o) {return  true;}
        if (o==null || this.getClass() != o.getClass()) {return  false;}
        LinhaDeEncomenda c = (LinhaDeEncomenda) o;
        if(this.imposto==c.getImposto()&&this.precoProduto==c.getPrecoProduto()
        &&this.descontoComercial==c.getDescontoComercial()&&this.referencia==c.getReferencia()
        &&this.descricao==c.getDescricao()&&this.quantidadeEnc==getQuantidadeEnc()) {return true;}
        else return false;
    }

    public LinhaDeEncomenda clone() {
        return new LinhaDeEncomenda(this);
    }

    public class Encomenda {

        private String nomeDoCliente;
        private int nrfiscal;
        private String moradaDoCliente;
        private int nrdeencomenda;
        private String datadaencomenda;
        private LinhaDeEncomenda [] linha_encomenda;

        public Encomenda() {
            this.nomeDoCliente = null;
            this.nrfiscal = 0;
            this.moradaDoCliente = null;
            this.nrdeencomenda = 0;
            this.datadaencomenda = null;
            this.linha_encomenda = null;
        }

        public String getDatadaencomenda() {
            return datadaencomenda;
        }

        public void setDatadaencomenda(String datadaencomenda) {
            this.datadaencomenda = datadaencomenda;
        }

        public String getNomeDoCliente() {
            return nomeDoCliente;
        }

        public void setNomeDoCliente(String nomeDoCliente) {
            this.nomeDoCliente = nomeDoCliente;
        }

        public int getNrfiscal() {
            return nrfiscal;
        }

        public void setNrfiscal(int nrfiscal) {
            this.nrfiscal = nrfiscal;
        }

        public String getMoradaDoCliente() {
            return moradaDoCliente;
        }

        public void setMoradaDoCliente(String moradaDoCliente) {
            this.moradaDoCliente = moradaDoCliente;
        }

        public int getNrdeencomenda() {
            return nrdeencomenda;
        }

        public void setNrdeencomenda(int nrdeencomenda) {
            this.nrdeencomenda = nrdeencomenda;
        }

        public LinhaDeEncomenda[] getLinha_encomenda() {
            return linha_encomenda;
        }

        public void setLinha_encomenda(LinhaDeEncomenda[] linha_encomenda) {
            this.linha_encomenda = linha_encomenda;
        }

        LinhaDeEncomenda l1 = new LinhaDeEncomenda();

            


    }



}

