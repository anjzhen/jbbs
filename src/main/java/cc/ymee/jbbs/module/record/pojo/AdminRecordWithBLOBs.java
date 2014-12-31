package cc.ymee.jbbs.module.record.pojo;

import java.io.Serializable;

public class AdminRecordWithBLOBs extends AdminRecord implements Serializable {
    private String sourceData;

    private String endData;

    private static final long serialVersionUID = 1L;

    public String getSourceData() {
        return sourceData;
    }

    public void setSourceData(String sourceData) {
        this.sourceData = sourceData == null ? null : sourceData.trim();
    }

    public String getEndData() {
        return endData;
    }

    public void setEndData(String endData) {
        this.endData = endData == null ? null : endData.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sourceData=").append(sourceData);
        sb.append(", endData=").append(endData);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}