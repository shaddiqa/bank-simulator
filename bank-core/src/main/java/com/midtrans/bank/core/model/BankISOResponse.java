package com.midtrans.bank.core.model;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/3/13
 * Time: 3:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankISOResponse {
    private Long pkBankISOResponse;

    private String description;

    private Integer fieldRequestNo;

    private Integer fieldResponseNo;

    private String staticValue;

    private Integer valueResponseType;

    private CommandTypeCondition commandTypeCondition;

    public Long getPkBankISOResponse() {
        return pkBankISOResponse;
    }

    public void setPkBankISOResponse(Long pkBankISOResponse) {
        this.pkBankISOResponse = pkBankISOResponse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getFieldRequestNo() {
        return fieldRequestNo;
    }

    public void setFieldRequestNo(Integer fieldRequestNo) {
        this.fieldRequestNo = fieldRequestNo;
    }

    public Integer getFieldResponseNo() {
        return fieldResponseNo;
    }

    public void setFieldResponseNo(Integer fieldResponseNo) {
        this.fieldResponseNo = fieldResponseNo;
    }

    public String getStaticValue() {
        return staticValue;
    }

    public void setStaticValue(String staticValue) {
        this.staticValue = staticValue;
    }

    public Integer getValueResponseType() {
        return valueResponseType;
    }

    public void setValueResponseType(Integer valueResponseType) {
        this.valueResponseType = valueResponseType;
    }

    public CommandTypeCondition getCommandTypeCondition() {
        return commandTypeCondition;
    }

    public void setCommandTypeCondition(CommandTypeCondition commandTypeCondition) {
        this.commandTypeCondition = commandTypeCondition;
    }
}
