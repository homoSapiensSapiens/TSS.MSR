package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This is a placeholder to allow testing of the dispatch code. */
public class TPM2_Vendor_TCG_Test_REQUEST extends TpmStructure
{
    /** dummy data */
    public byte[] inputData;
    
    public TPM2_Vendor_TCG_Test_REQUEST() {}
    
    /** @param _inputData dummy data */
    public TPM2_Vendor_TCG_Test_REQUEST(byte[] _inputData) { inputData = _inputData; }
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        buf.writeSizedByteBuf(inputData);
    }

    @Override
    public void initFromTpm(InByteBuf buf)
    {
        int _inputDataSize = buf.readShort() & 0xFFFF;
        inputData = new byte[_inputDataSize];
        buf.readArrayOfInts(inputData, 1, _inputDataSize);
    }

    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.getBuf();
    }

    public static TPM2_Vendor_TCG_Test_REQUEST fromTpm (byte[] x) 
    {
        TPM2_Vendor_TCG_Test_REQUEST ret = new TPM2_Vendor_TCG_Test_REQUEST();
        InByteBuf buf = new InByteBuf(x);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }

    public static TPM2_Vendor_TCG_Test_REQUEST fromTpm (InByteBuf buf) 
    {
        TPM2_Vendor_TCG_Test_REQUEST ret = new TPM2_Vendor_TCG_Test_REQUEST();
        ret.initFromTpm(buf);
        return ret;
    }

    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2_Vendor_TCG_Test_REQUEST");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }

    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "byte", "inputData", inputData);
    }
}

//<<<
