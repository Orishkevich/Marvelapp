package com.orishkevich.marvelapp;

/**Определение парметров памяти*/
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;

import java.text.DecimalFormat;

public class Memory {

    public long TotalMemory() {

        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long Total = (statFs.getBlockCountLong() * statFs.getBlockSizeLong());
        return Total;
    }

    public long FreeMemory() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long Free = (statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong());
        return Free;
    }

    public long BusyMemory() {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());

        long Busy = TotalMemory() - FreeMemory();
        return Busy;
    }

    public static String floatForm(double d) {
        return new DecimalFormat("#.##").format(d);
    }


    public static String bytesToHuman(long size) {
        long Kb = 1 * 1024;
        long Mb = Kb * 1024;
        long Gb = Mb * 1024;
        long Tb = Gb * 1024;
        long Pb = Tb * 1024;
        long Eb = Pb * 1024;

        if (size < Kb) return floatForm(size) + " byte";
        if (size >= Kb && size < Mb) return floatForm((double) size / Kb) + " Kb";
        if (size >= Mb && size < Gb) return floatForm((double) size / Mb) + " Mb";
        if (size >= Gb && size < Tb) return floatForm((double) size / Gb) + " Gb";
        if (size >= Tb && size < Pb) return floatForm((double) size / Tb) + " Tb";
        if (size >= Pb && size < Eb) return floatForm((double) size / Pb) + " Pb";
        if (size >= Eb) return floatForm((double) size / Eb) + " Eb";

        return "???";
    }
}
