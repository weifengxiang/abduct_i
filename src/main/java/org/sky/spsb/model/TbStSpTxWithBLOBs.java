package org.sky.spsb.model;

public class TbStSpTxWithBLOBs extends TbStSpTx {
    private String txnr;

    private String jt;

    public String getTxnr() {
        return txnr;
    }

    public void setTxnr(String txnr) {
        this.txnr = txnr;
    }

    public String getJt() {
        return jt;
    }

    public void setJt(String jt) {
        this.jt = jt;
    }
}