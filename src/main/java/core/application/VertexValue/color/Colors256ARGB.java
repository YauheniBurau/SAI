package core.application.VertexValue.color;

import core.application.process.ColorToColor.ArgbToLab;

import java.util.HashMap;

/**
 * Created by anonymous on 10.11.2018.
 */
public class Colors256ARGB {
    private ARGB[] listArgbColors;
    private Lab[] listLabColors;

    private HashMap<String, ARGB> mapArgbColors;

    public Colors256ARGB(){
        this.mapArgbColors = this.createNamedColors();
    }

    public static final ARGB 	_0_Black_SYSTEM	= new ARGB(0,0,0);
    public static final ARGB 	_1_Maroon_SYSTEM	= new ARGB(128,0,0);
    public static final ARGB 	_2_Green_SYSTEM	= new ARGB(0,128,0);
    public static final ARGB 	_3_Olive_SYSTEM	= new ARGB(128,128,0);
    public static final ARGB 	_4_Navy_SYSTEM	= new ARGB(0,0,128);
    public static final ARGB 	_5_Purple_SYSTEM	= new ARGB(128,0,128);
    public static final ARGB 	_6_Teal_SYSTEM	= new ARGB(0,128,128);
    public static final ARGB 	_7_Silver_SYSTEM	= new ARGB(192,192,192);
    public static final ARGB 	_8_Grey_SYSTEM	= new ARGB(128,128,128);
    public static final ARGB 	_9_Red_SYSTEM	= new ARGB(255,0,0);
    public static final ARGB 	_10_Lime_SYSTEM	= new ARGB(0,255,0);
    public static final ARGB 	_11_Yellow_SYSTEM	= new ARGB(255,255,0);
    public static final ARGB 	_12_Blue_SYSTEM	= new ARGB(0,0,255);
    public static final ARGB 	_13_Fuchsia_SYSTEM	= new ARGB(255,0,255);
    public static final ARGB 	_14_Aqua_SYSTEM	= new ARGB(0,255,255);
    public static final ARGB 	_15_White_SYSTEM	= new ARGB(255,255,255);
    public static final ARGB 	_16_Grey0	= new ARGB(0,0,0);
    public static final ARGB 	_17_NavyBlue	= new ARGB(0,0,95);
    public static final ARGB 	_18_DarkBlue	= new ARGB(0,0,135);
    public static final ARGB 	_19_Blue3	= new ARGB(0,0,175);
    public static final ARGB 	_20_Blue3	= new ARGB(0,0,215);
    public static final ARGB 	_21_Blue1	= new ARGB(0,0,255);
    public static final ARGB 	_22_DarkGreen	= new ARGB(0,95,0);
    public static final ARGB 	_23_DeepSkyBlue4	= new ARGB(0,95,95);
    public static final ARGB 	_24_DeepSkyBlue4	= new ARGB(0,95,135);
    public static final ARGB 	_25_DeepSkyBlue4	= new ARGB(0,95,175);
    public static final ARGB 	_26_DodgerBlue3	= new ARGB(0,95,215);
    public static final ARGB 	_27_DodgerBlue2	= new ARGB(0,95,255);
    public static final ARGB 	_28_Green4	= new ARGB(0,135,0);
    public static final ARGB 	_29_SpringGreen4	= new ARGB(0,135,95);
    public static final ARGB 	_30_Turquoise4	= new ARGB(0,135,135);
    public static final ARGB 	_31_DeepSkyBlue3	= new ARGB(0,135,175);
    public static final ARGB 	_32_DeepSkyBlue3	= new ARGB(0,135,215);
    public static final ARGB 	_33_DodgerBlue1	= new ARGB(0,135,255);
    public static final ARGB 	_34_Green3	= new ARGB(0,175,0);
    public static final ARGB 	_35_SpringGreen3	= new ARGB(0,175,95);
    public static final ARGB 	_36_DarkCyan	= new ARGB(0,175,135);
    public static final ARGB 	_37_LightSeaGreen	= new ARGB(0,175,175);
    public static final ARGB 	_38_DeepSkyBlue2	= new ARGB(0,175,215);
    public static final ARGB 	_39_DeepSkyBlue1	= new ARGB(0,175,255);
    public static final ARGB 	_40_Green3	= new ARGB(0,215,0);
    public static final ARGB 	_41_SpringGreen3	= new ARGB(0,215,95);
    public static final ARGB 	_42_SpringGreen2	= new ARGB(0,215,135);
    public static final ARGB 	_43_Cyan3	= new ARGB(0,215,175);
    public static final ARGB 	_44_DarkTurquoise	= new ARGB(0,215,215);
    public static final ARGB 	_45_Turquoise2	= new ARGB(0,215,255);
    public static final ARGB 	_46_Green1	= new ARGB(0,255,0);
    public static final ARGB 	_47_SpringGreen2	= new ARGB(0,255,95);
    public static final ARGB 	_48_SpringGreen1	= new ARGB(0,255,135);
    public static final ARGB 	_49_MediumSpringGreen	= new ARGB(0,255,175);
    public static final ARGB 	_50_Cyan2	= new ARGB(0,255,215);
    public static final ARGB 	_51_Cyan1	= new ARGB(0,255,255);
    public static final ARGB 	_52_DarkRed	= new ARGB(95,0,0);
    public static final ARGB 	_53_DeepPink4	= new ARGB(95,0,95);
    public static final ARGB 	_54_Purple4	= new ARGB(95,0,135);
    public static final ARGB 	_55_Purple4	= new ARGB(95,0,175);
    public static final ARGB 	_56_Purple3	= new ARGB(95,0,215);
    public static final ARGB 	_57_BlueViolet	= new ARGB(95,0,255);
    public static final ARGB 	_58_Orange4	= new ARGB(95,95,0);
    public static final ARGB 	_59_Grey37	= new ARGB(95,95,95);
    public static final ARGB 	_60_MediumPurple4	= new ARGB(95,95,135);
    public static final ARGB 	_61_SlateBlue3	= new ARGB(95,95,175);
    public static final ARGB 	_62_SlateBlue3	= new ARGB(95,95,215);
    public static final ARGB 	_63_RoyalBlue1	= new ARGB(95,95,255);
    public static final ARGB 	_64_Chartreuse4	= new ARGB(95,135,0);
    public static final ARGB 	_65_DarkSeaGreen4	= new ARGB(95,135,95);
    public static final ARGB 	_66_PaleTurquoise4	= new ARGB(95,135,135);
    public static final ARGB 	_67_SteelBlue	= new ARGB(95,135,175);
    public static final ARGB 	_68_SteelBlue3	= new ARGB(95,135,215);
    public static final ARGB 	_69_CornflowerBlue	= new ARGB(95,135,255);
    public static final ARGB 	_70_Chartreuse3	= new ARGB(95,175,0);
    public static final ARGB 	_71_DarkSeaGreen4	= new ARGB(95,175,95);
    public static final ARGB 	_72_CadetBlue	= new ARGB(95,175,135);
    public static final ARGB 	_73_CadetBlue	= new ARGB(95,175,175);
    public static final ARGB 	_74_SkyBlue3	= new ARGB(95,175,215);
    public static final ARGB 	_75_SteelBlue1	= new ARGB(95,175,255);
    public static final ARGB 	_76_Chartreuse3	= new ARGB(95,215,0);
    public static final ARGB 	_77_PaleGreen3	= new ARGB(95,215,95);
    public static final ARGB 	_78_SeaGreen3	= new ARGB(95,215,135);
    public static final ARGB 	_79_Aquamarine3	= new ARGB(95,215,175);
    public static final ARGB 	_80_MediumTurquoise	= new ARGB(95,215,215);
    public static final ARGB 	_81_SteelBlue1	= new ARGB(95,215,255);
    public static final ARGB 	_82_Chartreuse2	= new ARGB(95,255,0);
    public static final ARGB 	_83_SeaGreen2	= new ARGB(95,255,95);
    public static final ARGB 	_84_SeaGreen1	= new ARGB(95,255,135);
    public static final ARGB 	_85_SeaGreen1	= new ARGB(95,255,175);
    public static final ARGB 	_86_Aquamarine1	= new ARGB(95,255,215);
    public static final ARGB 	_87_DarkSlateGray2	= new ARGB(95,255,255);
    public static final ARGB 	_88_DarkRed	= new ARGB(135,0,0);
    public static final ARGB 	_89_DeepPink4	= new ARGB(135,0,95);
    public static final ARGB 	_90_DarkMagenta	= new ARGB(135,0,135);
    public static final ARGB 	_91_DarkMagenta	= new ARGB(135,0,175);
    public static final ARGB 	_92_DarkViolet	= new ARGB(135,0,215);
    public static final ARGB 	_93_Purple	= new ARGB(135,0,255);
    public static final ARGB 	_94_Orange4	= new ARGB(135,95,0);
    public static final ARGB 	_95_LightPink4	= new ARGB(135,95,95);
    public static final ARGB 	_96_Plum4	= new ARGB(135,95,135);
    public static final ARGB 	_97_MediumPurple3	= new ARGB(135,95,175);
    public static final ARGB 	_98_MediumPurple3	= new ARGB(135,95,215);
    public static final ARGB 	_99_SlateBlue1	= new ARGB(135,95,255);
    public static final ARGB 	_100_Yellow4	= new ARGB(135,135,0);
    public static final ARGB 	_101_Wheat4	= new ARGB(135,135,95);
    public static final ARGB 	_102_Grey53	= new ARGB(135,135,135);
    public static final ARGB 	_103_LightSlateGrey	= new ARGB(135,135,175);
    public static final ARGB 	_104_MediumPurple	= new ARGB(135,135,215);
    public static final ARGB 	_105_LightSlateBlue	= new ARGB(135,135,255);
    public static final ARGB 	_106_Yellow4	= new ARGB(135,175,0);
    public static final ARGB 	_107_DarkOliveGreen3	= new ARGB(135,175,95);
    public static final ARGB 	_108_DarkSeaGreen	= new ARGB(135,175,135);
    public static final ARGB 	_109_LightSkyBlue3	= new ARGB(135,175,175);
    public static final ARGB 	_110_LightSkyBlue3	= new ARGB(135,175,215);
    public static final ARGB 	_111_SkyBlue2	= new ARGB(135,175,255);
    public static final ARGB 	_112_Chartreuse2	= new ARGB(135,215,0);
    public static final ARGB 	_113_DarkOliveGreen3	= new ARGB(135,215,95);
    public static final ARGB 	_114_PaleGreen3	= new ARGB(135,215,135);
    public static final ARGB 	_115_DarkSeaGreen3	= new ARGB(135,215,175);
    public static final ARGB 	_116_DarkSlateGray3	= new ARGB(135,215,215);
    public static final ARGB 	_117_SkyBlue1	= new ARGB(135,215,255);
    public static final ARGB 	_118_Chartreuse1	= new ARGB(135,255,0);
    public static final ARGB 	_119_LightGreen	= new ARGB(135,255,95);
    public static final ARGB 	_120_LightGreen	= new ARGB(135,255,135);
    public static final ARGB 	_121_PaleGreen1	= new ARGB(135,255,175);
    public static final ARGB 	_122_Aquamarine1	= new ARGB(135,255,215);
    public static final ARGB 	_123_DarkSlateGray1	= new ARGB(135,255,255);
    public static final ARGB 	_124_Red3	= new ARGB(175,0,0);
    public static final ARGB 	_125_DeepPink4	= new ARGB(175,0,95);
    public static final ARGB 	_126_MediumVioletRed	= new ARGB(175,0,135);
    public static final ARGB 	_127_Magenta3	= new ARGB(175,0,175);
    public static final ARGB 	_128_DarkViolet	= new ARGB(175,0,215);
    public static final ARGB 	_129_Purple	= new ARGB(175,0,255);
    public static final ARGB 	_130_DarkOrange3	= new ARGB(175,95,0);
    public static final ARGB 	_131_IndianRed	= new ARGB(175,95,95);
    public static final ARGB 	_132_HotPink3	= new ARGB(175,95,135);
    public static final ARGB 	_133_MediumOrchid3	= new ARGB(175,95,175);
    public static final ARGB 	_134_MediumOrchid	= new ARGB(175,95,215);
    public static final ARGB 	_135_MediumPurple2	= new ARGB(175,95,255);
    public static final ARGB 	_136_DarkGoldenrod	= new ARGB(175,135,0);
    public static final ARGB 	_137_LightSalmon3	= new ARGB(175,135,95);
    public static final ARGB 	_138_RosyBrown	= new ARGB(175,135,135);
    public static final ARGB 	_139_Grey63	= new ARGB(175,135,175);
    public static final ARGB 	_140_MediumPurple2	= new ARGB(175,135,215);
    public static final ARGB 	_141_MediumPurple1	= new ARGB(175,135,255);
    public static final ARGB 	_142_Gold3	= new ARGB(175,175,0);
    public static final ARGB 	_143_DarkKhaki	= new ARGB(175,175,95);
    public static final ARGB 	_144_NavajoWhite3	= new ARGB(175,175,135);
    public static final ARGB 	_145_Grey69	= new ARGB(175,175,175);
    public static final ARGB 	_146_LightSteelBlue3	= new ARGB(175,175,215);
    public static final ARGB 	_147_LightSteelBlue	= new ARGB(175,175,255);
    public static final ARGB 	_148_Yellow3	= new ARGB(175,215,0);
    public static final ARGB 	_149_DarkOliveGreen3	= new ARGB(175,215,95);
    public static final ARGB 	_150_DarkSeaGreen3	= new ARGB(175,215,135);
    public static final ARGB 	_151_DarkSeaGreen2	= new ARGB(175,215,175);
    public static final ARGB 	_152_LightCyan3	= new ARGB(175,215,215);
    public static final ARGB 	_153_LightSkyBlue1	= new ARGB(175,215,255);
    public static final ARGB 	_154_GreenYellow	= new ARGB(175,255,0);
    public static final ARGB 	_155_DarkOliveGreen2	= new ARGB(175,255,95);
    public static final ARGB 	_156_PaleGreen1	= new ARGB(175,255,135);
    public static final ARGB 	_157_DarkSeaGreen2	= new ARGB(175,255,175);
    public static final ARGB 	_158_DarkSeaGreen1	= new ARGB(175,255,215);
    public static final ARGB 	_159_PaleTurquoise1	= new ARGB(175,255,255);
    public static final ARGB 	_160_Red3	= new ARGB(215,0,0);
    public static final ARGB 	_161_DeepPink3	= new ARGB(215,0,95);
    public static final ARGB 	_162_DeepPink3	= new ARGB(215,0,135);
    public static final ARGB 	_163_Magenta3	= new ARGB(215,0,175);
    public static final ARGB 	_164_Magenta3	= new ARGB(215,0,215);
    public static final ARGB 	_165_Magenta2	= new ARGB(215,0,255);
    public static final ARGB 	_166_DarkOrange3	= new ARGB(215,95,0);
    public static final ARGB 	_167_IndianRed	= new ARGB(215,95,95);
    public static final ARGB 	_168_HotPink3	= new ARGB(215,95,135);
    public static final ARGB 	_169_HotPink2	= new ARGB(215,95,175);
    public static final ARGB 	_170_Orchid	= new ARGB(215,95,215);
    public static final ARGB 	_171_MediumOrchid1	= new ARGB(215,95,255);
    public static final ARGB 	_172_Orange3	= new ARGB(215,135,0);
    public static final ARGB 	_173_LightSalmon3	= new ARGB(215,135,95);
    public static final ARGB 	_174_LightPink3	= new ARGB(215,135,135);
    public static final ARGB 	_175_Pink3	= new ARGB(215,135,175);
    public static final ARGB 	_176_Plum3	= new ARGB(215,135,215);
    public static final ARGB 	_177_Violet	= new ARGB(215,135,255);
    public static final ARGB 	_178_Gold3	= new ARGB(215,175,0);
    public static final ARGB 	_179_LightGoldenrod3	= new ARGB(215,175,95);
    public static final ARGB 	_180_Tan	= new ARGB(215,175,135);
    public static final ARGB 	_181_MistyRose3	= new ARGB(215,175,175);
    public static final ARGB 	_182_Thistle3	= new ARGB(215,175,215);
    public static final ARGB 	_183_Plum2	= new ARGB(215,175,255);
    public static final ARGB 	_184_Yellow3	= new ARGB(215,215,0);
    public static final ARGB 	_185_Khaki3	= new ARGB(215,215,95);
    public static final ARGB 	_186_LightGoldenrod2	= new ARGB(215,215,135);
    public static final ARGB 	_187_LightYellow3	= new ARGB(215,215,175);
    public static final ARGB 	_188_Grey84	= new ARGB(215,215,215);
    public static final ARGB 	_189_LightSteelBlue1	= new ARGB(215,215,255);
    public static final ARGB 	_190_Yellow2	= new ARGB(215,255,0);
    public static final ARGB 	_191_DarkOliveGreen1	= new ARGB(215,255,95);
    public static final ARGB 	_192_DarkOliveGreen1	= new ARGB(215,255,135);
    public static final ARGB 	_193_DarkSeaGreen1	= new ARGB(215,255,175);
    public static final ARGB 	_194_Honeydew2	= new ARGB(215,255,215);
    public static final ARGB 	_195_LightCyan1	= new ARGB(215,255,255);
    public static final ARGB 	_196_Red1	= new ARGB(255,0,0);
    public static final ARGB 	_197_DeepPink2	= new ARGB(255,0,95);
    public static final ARGB 	_198_DeepPink1	= new ARGB(255,0,135);
    public static final ARGB 	_199_DeepPink1	= new ARGB(255,0,175);
    public static final ARGB 	_200_Magenta2	= new ARGB(255,0,215);
    public static final ARGB 	_201_Magenta1	= new ARGB(255,0,255);
    public static final ARGB 	_202_OrangeRed1	= new ARGB(255,95,0);
    public static final ARGB 	_203_IndianRed1	= new ARGB(255,95,95);
    public static final ARGB 	_204_IndianRed1	= new ARGB(255,95,135);
    public static final ARGB 	_205_HotPink	= new ARGB(255,95,175);
    public static final ARGB 	_206_HotPink	= new ARGB(255,95,215);
    public static final ARGB 	_207_MediumOrchid1	= new ARGB(255,95,255);
    public static final ARGB 	_208_DarkOrange	= new ARGB(255,135,0);
    public static final ARGB 	_209_Salmon1	= new ARGB(255,135,95);
    public static final ARGB 	_210_LightCoral	= new ARGB(255,135,135);
    public static final ARGB 	_211_PaleVioletRed1	= new ARGB(255,135,175);
    public static final ARGB 	_212_Orchid2	= new ARGB(255,135,215);
    public static final ARGB 	_213_Orchid1	= new ARGB(255,135,255);
    public static final ARGB 	_214_Orange1	= new ARGB(255,175,0);
    public static final ARGB 	_215_SandyBrown	= new ARGB(255,175,95);
    public static final ARGB 	_216_LightSalmon1	= new ARGB(255,175,135);
    public static final ARGB 	_217_LightPink1	= new ARGB(255,175,175);
    public static final ARGB 	_218_Pink1	= new ARGB(255,175,215);
    public static final ARGB 	_219_Plum1	= new ARGB(255,175,255);
    public static final ARGB 	_220_Gold1	= new ARGB(255,215,0);
    public static final ARGB 	_221_LightGoldenrod2	= new ARGB(255,215,95);
    public static final ARGB 	_222_LightGoldenrod2	= new ARGB(255,215,135);
    public static final ARGB 	_223_NavajoWhite1	= new ARGB(255,215,175);
    public static final ARGB 	_224_MistyRose1	= new ARGB(255,215,215);
    public static final ARGB 	_225_Thistle1	= new ARGB(255,215,255);
    public static final ARGB 	_226_Yellow1	= new ARGB(255,255,0);
    public static final ARGB 	_227_LightGoldenrod1	= new ARGB(255,255,95);
    public static final ARGB 	_228_Khaki1	= new ARGB(255,255,135);
    public static final ARGB 	_229_Wheat1	= new ARGB(255,255,175);
    public static final ARGB 	_230_Cornsilk1	= new ARGB(255,255,215);
    public static final ARGB 	_231_Grey100	= new ARGB(255,255,255);
    public static final ARGB 	_232_Grey3	= new ARGB(8,8,8);
    public static final ARGB 	_233_Grey7	= new ARGB(18,18,18);
    public static final ARGB 	_234_Grey11	= new ARGB(28,28,28);
    public static final ARGB 	_235_Grey15	= new ARGB(38,38,38);
    public static final ARGB 	_236_Grey19	= new ARGB(48,48,48);
    public static final ARGB 	_237_Grey23	= new ARGB(58,58,58);
    public static final ARGB 	_238_Grey27	= new ARGB(68,68,68);
    public static final ARGB 	_239_Grey30	= new ARGB(78,78,78);
    public static final ARGB 	_240_Grey35	= new ARGB(88,88,88);
    public static final ARGB 	_241_Grey39	= new ARGB(98,98,98);
    public static final ARGB 	_242_Grey42	= new ARGB(108,108,108);
    public static final ARGB 	_243_Grey46	= new ARGB(118,118,118);
    public static final ARGB 	_244_Grey50	= new ARGB(128,128,128);
    public static final ARGB 	_245_Grey54	= new ARGB(138,138,138);
    public static final ARGB 	_246_Grey58	= new ARGB(148,148,148);
    public static final ARGB 	_247_Grey62	= new ARGB(158,158,158);
    public static final ARGB 	_248_Grey66	= new ARGB(168,168,168);
    public static final ARGB 	_249_Grey70	= new ARGB(178,178,178);
    public static final ARGB 	_250_Grey74	= new ARGB(188,188,188);
    public static final ARGB 	_251_Grey78	= new ARGB(198,198,198);
    public static final ARGB 	_252_Grey82	= new ARGB(208,208,208);
    public static final ARGB 	_253_Grey85	= new ARGB(218,218,218);
    public static final ARGB 	_254_Grey89	= new ARGB(228,228,228);
    public static final ARGB 	_255_Grey93	= new ARGB(238,238,238);

    private HashMap<String, ARGB> createNamedColors() {
        this.mapArgbColors = new HashMap<String, ARGB>(256);
        mapArgbColors.put("_0_Black_SYSTEM",	_0_Black_SYSTEM	);
        mapArgbColors.put("_1_Maroon_SYSTEM",	_1_Maroon_SYSTEM	);
        mapArgbColors.put("_2_Green_SYSTEM",	_2_Green_SYSTEM	);
        mapArgbColors.put("_3_Olive_SYSTEM",	_3_Olive_SYSTEM	);
        mapArgbColors.put("_4_Navy_SYSTEM",	_4_Navy_SYSTEM	);
        mapArgbColors.put("_5_Purple_SYSTEM",	_5_Purple_SYSTEM	);
        mapArgbColors.put("_6_Teal_SYSTEM",	_6_Teal_SYSTEM	);
        mapArgbColors.put("_7_Silver_SYSTEM",	_7_Silver_SYSTEM	);
        mapArgbColors.put("_8_Grey_SYSTEM",	_8_Grey_SYSTEM	);
        mapArgbColors.put("_9_Red_SYSTEM",	_9_Red_SYSTEM	);
        mapArgbColors.put("_10_Lime_SYSTEM",	_10_Lime_SYSTEM	);
        mapArgbColors.put("_11_Yellow_SYSTEM",	_11_Yellow_SYSTEM	);
        mapArgbColors.put("_12_Blue_SYSTEM",	_12_Blue_SYSTEM	);
        mapArgbColors.put("_13_Fuchsia_SYSTEM",	_13_Fuchsia_SYSTEM	);
        mapArgbColors.put("_14_Aqua_SYSTEM",	_14_Aqua_SYSTEM	);
        mapArgbColors.put("_15_White_SYSTEM",	_15_White_SYSTEM	);
        mapArgbColors.put("_16_Grey0",	_16_Grey0	);
        mapArgbColors.put("_17_NavyBlue",	_17_NavyBlue	);
        mapArgbColors.put("_18_DarkBlue",	_18_DarkBlue	);
        mapArgbColors.put("_19_Blue3",	_19_Blue3	);
        mapArgbColors.put("_20_Blue3",	_20_Blue3	);
        mapArgbColors.put("_21_Blue1",	_21_Blue1	);
        mapArgbColors.put("_22_DarkGreen",	_22_DarkGreen	);
        mapArgbColors.put("_23_DeepSkyBlue4",	_23_DeepSkyBlue4	);
        mapArgbColors.put("_24_DeepSkyBlue4",	_24_DeepSkyBlue4	);
        mapArgbColors.put("_25_DeepSkyBlue4",	_25_DeepSkyBlue4	);
        mapArgbColors.put("_26_DodgerBlue3",	_26_DodgerBlue3	);
        mapArgbColors.put("_27_DodgerBlue2",	_27_DodgerBlue2	);
        mapArgbColors.put("_28_Green4",	_28_Green4	);
        mapArgbColors.put("_29_SpringGreen4",	_29_SpringGreen4	);
        mapArgbColors.put("_30_Turquoise4",	_30_Turquoise4	);
        mapArgbColors.put("_31_DeepSkyBlue3",	_31_DeepSkyBlue3	);
        mapArgbColors.put("_32_DeepSkyBlue3",	_32_DeepSkyBlue3	);
        mapArgbColors.put("_33_DodgerBlue1",	_33_DodgerBlue1	);
        mapArgbColors.put("_34_Green3",	_34_Green3	);
        mapArgbColors.put("_35_SpringGreen3",	_35_SpringGreen3	);
        mapArgbColors.put("_36_DarkCyan",	_36_DarkCyan	);
        mapArgbColors.put("_37_LightSeaGreen",	_37_LightSeaGreen	);
        mapArgbColors.put("_38_DeepSkyBlue2",	_38_DeepSkyBlue2	);
        mapArgbColors.put("_39_DeepSkyBlue1",	_39_DeepSkyBlue1	);
        mapArgbColors.put("_40_Green3",	_40_Green3	);
        mapArgbColors.put("_41_SpringGreen3",	_41_SpringGreen3	);
        mapArgbColors.put("_42_SpringGreen2",	_42_SpringGreen2	);
        mapArgbColors.put("_43_Cyan3",	_43_Cyan3	);
        mapArgbColors.put("_44_DarkTurquoise",	_44_DarkTurquoise	);
        mapArgbColors.put("_45_Turquoise2",	_45_Turquoise2	);
        mapArgbColors.put("_46_Green1",	_46_Green1	);
        mapArgbColors.put("_47_SpringGreen2",	_47_SpringGreen2	);
        mapArgbColors.put("_48_SpringGreen1",	_48_SpringGreen1	);
        mapArgbColors.put("_49_MediumSpringGreen",	_49_MediumSpringGreen	);
        mapArgbColors.put("_50_Cyan2",	_50_Cyan2	);
        mapArgbColors.put("_51_Cyan1",	_51_Cyan1	);
        mapArgbColors.put("_52_DarkRed",	_52_DarkRed	);
        mapArgbColors.put("_53_DeepPink4",	_53_DeepPink4	);
        mapArgbColors.put("_54_Purple4",	_54_Purple4	);
        mapArgbColors.put("_55_Purple4",	_55_Purple4	);
        mapArgbColors.put("_56_Purple3",	_56_Purple3	);
        mapArgbColors.put("_57_BlueViolet",	_57_BlueViolet	);
        mapArgbColors.put("_58_Orange4",	_58_Orange4	);
        mapArgbColors.put("_59_Grey37",	_59_Grey37	);
        mapArgbColors.put("_60_MediumPurple4",	_60_MediumPurple4	);
        mapArgbColors.put("_61_SlateBlue3",	_61_SlateBlue3	);
        mapArgbColors.put("_62_SlateBlue3",	_62_SlateBlue3	);
        mapArgbColors.put("_63_RoyalBlue1",	_63_RoyalBlue1	);
        mapArgbColors.put("_64_Chartreuse4",	_64_Chartreuse4	);
        mapArgbColors.put("_65_DarkSeaGreen4",	_65_DarkSeaGreen4	);
        mapArgbColors.put("_66_PaleTurquoise4",	_66_PaleTurquoise4	);
        mapArgbColors.put("_67_SteelBlue",	_67_SteelBlue	);
        mapArgbColors.put("_68_SteelBlue3",	_68_SteelBlue3	);
        mapArgbColors.put("_69_CornflowerBlue",	_69_CornflowerBlue	);
        mapArgbColors.put("_70_Chartreuse3",	_70_Chartreuse3	);
        mapArgbColors.put("_71_DarkSeaGreen4",	_71_DarkSeaGreen4	);
        mapArgbColors.put("_72_CadetBlue",	_72_CadetBlue	);
        mapArgbColors.put("_73_CadetBlue",	_73_CadetBlue	);
        mapArgbColors.put("_74_SkyBlue3",	_74_SkyBlue3	);
        mapArgbColors.put("_75_SteelBlue1",	_75_SteelBlue1	);
        mapArgbColors.put("_76_Chartreuse3",	_76_Chartreuse3	);
        mapArgbColors.put("_77_PaleGreen3",	_77_PaleGreen3	);
        mapArgbColors.put("_78_SeaGreen3",	_78_SeaGreen3	);
        mapArgbColors.put("_79_Aquamarine3",	_79_Aquamarine3	);
        mapArgbColors.put("_80_MediumTurquoise",	_80_MediumTurquoise	);
        mapArgbColors.put("_81_SteelBlue1",	_81_SteelBlue1	);
        mapArgbColors.put("_82_Chartreuse2",	_82_Chartreuse2	);
        mapArgbColors.put("_83_SeaGreen2",	_83_SeaGreen2	);
        mapArgbColors.put("_84_SeaGreen1",	_84_SeaGreen1	);
        mapArgbColors.put("_85_SeaGreen1",	_85_SeaGreen1	);
        mapArgbColors.put("_86_Aquamarine1",	_86_Aquamarine1	);
        mapArgbColors.put("_87_DarkSlateGray2",	_87_DarkSlateGray2	);
        mapArgbColors.put("_88_DarkRed",	_88_DarkRed	);
        mapArgbColors.put("_89_DeepPink4",	_89_DeepPink4	);
        mapArgbColors.put("_90_DarkMagenta",	_90_DarkMagenta	);
        mapArgbColors.put("_91_DarkMagenta",	_91_DarkMagenta	);
        mapArgbColors.put("_92_DarkViolet",	_92_DarkViolet	);
        mapArgbColors.put("_93_Purple",	_93_Purple	);
        mapArgbColors.put("_94_Orange4",	_94_Orange4	);
        mapArgbColors.put("_95_LightPink4",	_95_LightPink4	);
        mapArgbColors.put("_96_Plum4",	_96_Plum4	);
        mapArgbColors.put("_97_MediumPurple3",	_97_MediumPurple3	);
        mapArgbColors.put("_98_MediumPurple3",	_98_MediumPurple3	);
        mapArgbColors.put("_99_SlateBlue1",	_99_SlateBlue1	);
        mapArgbColors.put("_100_Yellow4",	_100_Yellow4	);
        mapArgbColors.put("_101_Wheat4",	_101_Wheat4	);
        mapArgbColors.put("_102_Grey53",	_102_Grey53	);
        mapArgbColors.put("_103_LightSlateGrey",	_103_LightSlateGrey	);
        mapArgbColors.put("_104_MediumPurple",	_104_MediumPurple	);
        mapArgbColors.put("_105_LightSlateBlue",	_105_LightSlateBlue	);
        mapArgbColors.put("_106_Yellow4",	_106_Yellow4	);
        mapArgbColors.put("_107_DarkOliveGreen3",	_107_DarkOliveGreen3	);
        mapArgbColors.put("_108_DarkSeaGreen",	_108_DarkSeaGreen	);
        mapArgbColors.put("_109_LightSkyBlue3",	_109_LightSkyBlue3	);
        mapArgbColors.put("_110_LightSkyBlue3",	_110_LightSkyBlue3	);
        mapArgbColors.put("_111_SkyBlue2",	_111_SkyBlue2	);
        mapArgbColors.put("_112_Chartreuse2",	_112_Chartreuse2	);
        mapArgbColors.put("_113_DarkOliveGreen3",	_113_DarkOliveGreen3	);
        mapArgbColors.put("_114_PaleGreen3",	_114_PaleGreen3	);
        mapArgbColors.put("_115_DarkSeaGreen3",	_115_DarkSeaGreen3	);
        mapArgbColors.put("_116_DarkSlateGray3",	_116_DarkSlateGray3	);
        mapArgbColors.put("_117_SkyBlue1",	_117_SkyBlue1	);
        mapArgbColors.put("_118_Chartreuse1",	_118_Chartreuse1	);
        mapArgbColors.put("_119_LightGreen",	_119_LightGreen	);
        mapArgbColors.put("_120_LightGreen",	_120_LightGreen	);
        mapArgbColors.put("_121_PaleGreen1",	_121_PaleGreen1	);
        mapArgbColors.put("_122_Aquamarine1",	_122_Aquamarine1	);
        mapArgbColors.put("_123_DarkSlateGray1",	_123_DarkSlateGray1	);
        mapArgbColors.put("_124_Red3",	_124_Red3	);
        mapArgbColors.put("_125_DeepPink4",	_125_DeepPink4	);
        mapArgbColors.put("_126_MediumVioletRed",	_126_MediumVioletRed	);
        mapArgbColors.put("_127_Magenta3",	_127_Magenta3	);
        mapArgbColors.put("_128_DarkViolet",	_128_DarkViolet	);
        mapArgbColors.put("_129_Purple",	_129_Purple	);
        mapArgbColors.put("_130_DarkOrange3",	_130_DarkOrange3	);
        mapArgbColors.put("_131_IndianRed",	_131_IndianRed	);
        mapArgbColors.put("_132_HotPink3",	_132_HotPink3	);
        mapArgbColors.put("_133_MediumOrchid3",	_133_MediumOrchid3	);
        mapArgbColors.put("_134_MediumOrchid",	_134_MediumOrchid	);
        mapArgbColors.put("_135_MediumPurple2",	_135_MediumPurple2	);
        mapArgbColors.put("_136_DarkGoldenrod",	_136_DarkGoldenrod	);
        mapArgbColors.put("_137_LightSalmon3",	_137_LightSalmon3	);
        mapArgbColors.put("_138_RosyBrown",	_138_RosyBrown	);
        mapArgbColors.put("_139_Grey63",	_139_Grey63	);
        mapArgbColors.put("_140_MediumPurple2",	_140_MediumPurple2	);
        mapArgbColors.put("_141_MediumPurple1",	_141_MediumPurple1	);
        mapArgbColors.put("_142_Gold3",	_142_Gold3	);
        mapArgbColors.put("_143_DarkKhaki",	_143_DarkKhaki	);
        mapArgbColors.put("_144_NavajoWhite3",	_144_NavajoWhite3	);
        mapArgbColors.put("_145_Grey69",	_145_Grey69	);
        mapArgbColors.put("_146_LightSteelBlue3",	_146_LightSteelBlue3	);
        mapArgbColors.put("_147_LightSteelBlue",	_147_LightSteelBlue	);
        mapArgbColors.put("_148_Yellow3",	_148_Yellow3	);
        mapArgbColors.put("_149_DarkOliveGreen3",	_149_DarkOliveGreen3	);
        mapArgbColors.put("_150_DarkSeaGreen3",	_150_DarkSeaGreen3	);
        mapArgbColors.put("_151_DarkSeaGreen2",	_151_DarkSeaGreen2	);
        mapArgbColors.put("_152_LightCyan3",	_152_LightCyan3	);
        mapArgbColors.put("_153_LightSkyBlue1",	_153_LightSkyBlue1	);
        mapArgbColors.put("_154_GreenYellow",	_154_GreenYellow	);
        mapArgbColors.put("_155_DarkOliveGreen2",	_155_DarkOliveGreen2	);
        mapArgbColors.put("_156_PaleGreen1",	_156_PaleGreen1	);
        mapArgbColors.put("_157_DarkSeaGreen2",	_157_DarkSeaGreen2	);
        mapArgbColors.put("_158_DarkSeaGreen1",	_158_DarkSeaGreen1	);
        mapArgbColors.put("_159_PaleTurquoise1",	_159_PaleTurquoise1	);
        mapArgbColors.put("_160_Red3",	_160_Red3	);
        mapArgbColors.put("_161_DeepPink3",	_161_DeepPink3	);
        mapArgbColors.put("_162_DeepPink3",	_162_DeepPink3	);
        mapArgbColors.put("_163_Magenta3",	_163_Magenta3	);
        mapArgbColors.put("_164_Magenta3",	_164_Magenta3	);
        mapArgbColors.put("_165_Magenta2",	_165_Magenta2	);
        mapArgbColors.put("_166_DarkOrange3",	_166_DarkOrange3	);
        mapArgbColors.put("_167_IndianRed",	_167_IndianRed	);
        mapArgbColors.put("_168_HotPink3",	_168_HotPink3	);
        mapArgbColors.put("_169_HotPink2",	_169_HotPink2	);
        mapArgbColors.put("_170_Orchid",	_170_Orchid	);
        mapArgbColors.put("_171_MediumOrchid1",	_171_MediumOrchid1	);
        mapArgbColors.put("_172_Orange3",	_172_Orange3	);
        mapArgbColors.put("_173_LightSalmon3",	_173_LightSalmon3	);
        mapArgbColors.put("_174_LightPink3",	_174_LightPink3	);
        mapArgbColors.put("_175_Pink3",	_175_Pink3	);
        mapArgbColors.put("_176_Plum3",	_176_Plum3	);
        mapArgbColors.put("_177_Violet",	_177_Violet	);
        mapArgbColors.put("_178_Gold3",	_178_Gold3	);
        mapArgbColors.put("_179_LightGoldenrod3",	_179_LightGoldenrod3	);
        mapArgbColors.put("_180_Tan",	_180_Tan	);
        mapArgbColors.put("_181_MistyRose3",	_181_MistyRose3	);
        mapArgbColors.put("_182_Thistle3",	_182_Thistle3	);
        mapArgbColors.put("_183_Plum2",	_183_Plum2	);
        mapArgbColors.put("_184_Yellow3",	_184_Yellow3	);
        mapArgbColors.put("_185_Khaki3",	_185_Khaki3	);
        mapArgbColors.put("_186_LightGoldenrod2",	_186_LightGoldenrod2	);
        mapArgbColors.put("_187_LightYellow3",	_187_LightYellow3	);
        mapArgbColors.put("_188_Grey84",	_188_Grey84	);
        mapArgbColors.put("_189_LightSteelBlue1",	_189_LightSteelBlue1	);
        mapArgbColors.put("_190_Yellow2",	_190_Yellow2	);
        mapArgbColors.put("_191_DarkOliveGreen1",	_191_DarkOliveGreen1	);
        mapArgbColors.put("_192_DarkOliveGreen1",	_192_DarkOliveGreen1	);
        mapArgbColors.put("_193_DarkSeaGreen1",	_193_DarkSeaGreen1	);
        mapArgbColors.put("_194_Honeydew2",	_194_Honeydew2	);
        mapArgbColors.put("_195_LightCyan1",	_195_LightCyan1	);
        mapArgbColors.put("_196_Red1",	_196_Red1	);
        mapArgbColors.put("_197_DeepPink2",	_197_DeepPink2	);
        mapArgbColors.put("_198_DeepPink1",	_198_DeepPink1	);
        mapArgbColors.put("_199_DeepPink1",	_199_DeepPink1	);
        mapArgbColors.put("_200_Magenta2",	_200_Magenta2	);
        mapArgbColors.put("_201_Magenta1",	_201_Magenta1	);
        mapArgbColors.put("_202_OrangeRed1",	_202_OrangeRed1	);
        mapArgbColors.put("_203_IndianRed1",	_203_IndianRed1	);
        mapArgbColors.put("_204_IndianRed1",	_204_IndianRed1	);
        mapArgbColors.put("_205_HotPink",	_205_HotPink	);
        mapArgbColors.put("_206_HotPink",	_206_HotPink	);
        mapArgbColors.put("_207_MediumOrchid1",	_207_MediumOrchid1	);
        mapArgbColors.put("_208_DarkOrange",	_208_DarkOrange	);
        mapArgbColors.put("_209_Salmon1",	_209_Salmon1	);
        mapArgbColors.put("_210_LightCoral",	_210_LightCoral	);
        mapArgbColors.put("_211_PaleVioletRed1",	_211_PaleVioletRed1	);
        mapArgbColors.put("_212_Orchid2",	_212_Orchid2	);
        mapArgbColors.put("_213_Orchid1",	_213_Orchid1	);
        mapArgbColors.put("_214_Orange1",	_214_Orange1	);
        mapArgbColors.put("_215_SandyBrown",	_215_SandyBrown	);
        mapArgbColors.put("_216_LightSalmon1",	_216_LightSalmon1	);
        mapArgbColors.put("_217_LightPink1",	_217_LightPink1	);
        mapArgbColors.put("_218_Pink1",	_218_Pink1	);
        mapArgbColors.put("_219_Plum1",	_219_Plum1	);
        mapArgbColors.put("_220_Gold1",	_220_Gold1	);
        mapArgbColors.put("_221_LightGoldenrod2",	_221_LightGoldenrod2	);
        mapArgbColors.put("_222_LightGoldenrod2",	_222_LightGoldenrod2	);
        mapArgbColors.put("_223_NavajoWhite1",	_223_NavajoWhite1	);
        mapArgbColors.put("_224_MistyRose1",	_224_MistyRose1	);
        mapArgbColors.put("_225_Thistle1",	_225_Thistle1	);
        mapArgbColors.put("_226_Yellow1",	_226_Yellow1	);
        mapArgbColors.put("_227_LightGoldenrod1",	_227_LightGoldenrod1	);
        mapArgbColors.put("_228_Khaki1",	_228_Khaki1	);
        mapArgbColors.put("_229_Wheat1",	_229_Wheat1	);
        mapArgbColors.put("_230_Cornsilk1",	_230_Cornsilk1	);
        mapArgbColors.put("_231_Grey100",	_231_Grey100	);
        mapArgbColors.put("_232_Grey3",	_232_Grey3	);
        mapArgbColors.put("_233_Grey7",	_233_Grey7	);
        mapArgbColors.put("_234_Grey11",	_234_Grey11	);
        mapArgbColors.put("_235_Grey15",	_235_Grey15	);
        mapArgbColors.put("_236_Grey19",	_236_Grey19	);
        mapArgbColors.put("_237_Grey23",	_237_Grey23	);
        mapArgbColors.put("_238_Grey27",	_238_Grey27	);
        mapArgbColors.put("_239_Grey30",	_239_Grey30	);
        mapArgbColors.put("_240_Grey35",	_240_Grey35	);
        mapArgbColors.put("_241_Grey39",	_241_Grey39	);
        mapArgbColors.put("_242_Grey42",	_242_Grey42	);
        mapArgbColors.put("_243_Grey46",	_243_Grey46	);
        mapArgbColors.put("_244_Grey50",	_244_Grey50	);
        mapArgbColors.put("_245_Grey54",	_245_Grey54	);
        mapArgbColors.put("_246_Grey58",	_246_Grey58	);
        mapArgbColors.put("_247_Grey62",	_247_Grey62	);
        mapArgbColors.put("_248_Grey66",	_248_Grey66	);
        mapArgbColors.put("_249_Grey70",	_249_Grey70	);
        mapArgbColors.put("_250_Grey74",	_250_Grey74	);
        mapArgbColors.put("_251_Grey78",	_251_Grey78	);
        mapArgbColors.put("_252_Grey82",	_252_Grey82	);
        mapArgbColors.put("_253_Grey85",	_253_Grey85	);
        mapArgbColors.put("_254_Grey89",	_254_Grey89	);
        mapArgbColors.put("_255_Grey93",	_255_Grey93	);
        this.listArgbColors = this.mapArgbColors.values().toArray(new ARGB[256]);
        this.listLabColors = new Lab[256];
        for(int i =0; i<256;i++){
            this.listLabColors[i] = ArgbToLab.transform(this.listArgbColors[i]);
        }
        return mapArgbColors;
    }

    public ARGB getArgbColor(int index) {
        return this.listArgbColors[index];
    }

    public Lab getLabColor(int index) {
        return this.listLabColors[index];
    }

    public static ARGB removeAlpha(ARGB foreground, ARGB background)
    {
        if (foreground.a == 255)
            return foreground;

        double alpha = foreground.a / 255.0;
        double diff = 1.0 - alpha;
        return new ARGB(255,
                (byte)(foreground.r * alpha + background.r * diff),
                (byte)(foreground.g * alpha + background.g * diff),
                (byte)(foreground.b * alpha + background.b * diff));
    }

    public static double countColourDistance(ARGB p1, ARGB p2){
        return Math.sqrt( (p2.r - p1.r)*(p2.r - p1.r) + (p2.g - p1.g)*(p2.g - p1.g) + (p2.b - p1.b)*(p2.b - p1.b) );
//        return Math.abs((p2.r - p1.r) + (p2.g - p1.g) + (p2.b - p1.b));
    }

//    public static double countColourDistance(Lab e1, Lab e2)
//    {
//        double l = e1.L - e2.L;
//        double a = e1.a - e2.a;
//        double b = e1.b - e2.b;
//        return Math.sqrt(l*l + a*a + b*b);
//    }

//    public static double countColourDistance(ARGB e1, ARGB e2)
//    {
//        long rmean = ( (long)e1.r + (long)e2.r ) / 2;
//        long r = (long)e1.r - (long)e2.r;
//        long g = (long)e1.g - (long)e2.g;
//        long b = (long)e1.b - (long)e2.b;
//        return Math.sqrt((((512+rmean)*r*r)>>8) + 4*g*g + (((767-rmean)*b*b)>>8));
//    }

    public ARGB findClosestColor256(ARGB in){
        ARGB out = null, argbColor;
        ARGB in1, background = new ARGB(0xffffffff);
        Lab labColor;
        double dist, minDist = 1024;
        //in1 = Colors256ARGB.removeAlpha(in, background);
        for(int i =0; i<256; i++){
            argbColor = this.listArgbColors[i];
            // labColor = this.listLabColors[i];
            //            dist = Colors256ARGB.countColourDistance(in, color);
            dist = Colors256ARGB.countColourDistance(in, argbColor);
            if(dist<minDist){
                minDist = dist;
                out = new ARGB(in.a, argbColor.r, argbColor.g, argbColor.b);
            }
        }
        return out;
    }

    public int findClosestColor256Index(ARGB in){
        ARGB argbColor;
        int index = 0;
        double dist, minDist = 1024;
        //in1 = Colors256ARGB.removeAlpha(in, background);
        for(int i=0; i<256; i++){
            argbColor = this.listArgbColors[i];
            dist = Colors256ARGB.countColourDistance(in, argbColor);
            if(dist<minDist){
                minDist = dist;
                index = i;
            }
        }
        return index;
    }

    public ARGB findClosestColor16(ARGB in){
        ARGB out = null, argbColor;
        double dist, minDist = 255*3;
        for(int i =0; i<16; i++){
            argbColor = this.listArgbColors[i];
            // labColor = this.listLabColors[i];
            //            dist = Colors256ARGB.countColourDistance(in, color);
            dist = Colors256ARGB.countColourDistance(in, argbColor);
            if(dist<minDist){
                minDist = dist;
                out = new ARGB(in.a, argbColor.r, argbColor.g, argbColor.b);
            }
        }
        return out;
    }

}
