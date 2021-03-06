package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/**
 *  This list is used to report on a list of properties that are TPMS_TAGGED_PROPERTY values. It is
 *  returned by a TPM2_GetCapability().
 */
public class TPML_TAGGED_TPM_PROPERTY extends TpmStructure implements TPMU_CAPABILITIES
{
    /** an array of tagged properties */
    public TPMS_TAGGED_PROPERTY[] tpmProperty;
    
    public TPML_TAGGED_TPM_PROPERTY() {}
    
    /** @param _tpmProperty an array of tagged properties */
    public TPML_TAGGED_TPM_PROPERTY(TPMS_TAGGED_PROPERTY[] _tpmProperty) { tpmProperty = _tpmProperty; }
    
    /** TpmUnion method */
    public TPM_CAP GetUnionSelector() { return TPM_CAP.TPM_PROPERTIES; }
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        buf.writeObjArr(tpmProperty);
    }

    @Override
    public void initFromTpm(InByteBuf buf)
    {
        int _count = buf.readInt();
        tpmProperty = new TPMS_TAGGED_PROPERTY[_count];
        for (int j=0; j < _count; j++) tpmProperty[j] = new TPMS_TAGGED_PROPERTY();
        buf.readArrayOfTpmObjects(tpmProperty, _count);
    }

    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.getBuf();
    }

    public static TPML_TAGGED_TPM_PROPERTY fromTpm (byte[] x) 
    {
        TPML_TAGGED_TPM_PROPERTY ret = new TPML_TAGGED_TPM_PROPERTY();
        InByteBuf buf = new InByteBuf(x);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }

    public static TPML_TAGGED_TPM_PROPERTY fromTpm (InByteBuf buf) 
    {
        TPML_TAGGED_TPM_PROPERTY ret = new TPML_TAGGED_TPM_PROPERTY();
        ret.initFromTpm(buf);
        return ret;
    }

    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPML_TAGGED_TPM_PROPERTY");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }

    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "TPMS_TAGGED_PROPERTY", "tpmProperty", tpmProperty);
    }
}

//<<<
