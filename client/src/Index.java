/* Class45 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Index {
    static int anInt626;
    static int anInt627;
    static int anInt628;
    private Class291 index = null;
    static int anInt630;
    static int anInt631;
    static int anInt632;
    static int anInt633;
    int discardUnpacked; // anInt634
    static int anInt635;
    static int anInt636;
    static int anInt637;
    static int anInt638;
    static int anInt639;
    static int anInt640;
    static int anInt641;
    static int anInt642;
    static Class351 aClass351_643 = new Class351(3, -1);
    static int anInt644;
    static int anInt645;
    static int anInt646;
    static int anInt647;
    static int anInt648;
    static int anInt649;
    static int anInt650;
    static int anInt651;
    static int anInt652;
    static int anInt653;
    static int anInt654;
    private final boolean discardPacked;
    private Object[] packed;
    static int anInt657;
    static int anInt658;
    private ResourceProvider provider;
    static int anInt660;
    static int anInt661;
    static int anInt662;
    static int anInt663;
    private Object[][] unpacked;
    static int anInt665;
    static int anInt666;
    static long aLong667;
    static int anInt668;
    static int anInt669 = 0;
    static float aFloat670;

    // method389
    final int indexCrc(int i) {
        int i_0_ = -117 / ((-60 - i) / 33);
        anInt657++;
        if (!indexReady(false)) throw new IllegalStateException("");
        return index.anInt3719;
    }

    public static void method390(byte i) {
        aClass351_643 = null;
        if (i != 10) method390((byte) -3);
    }

    final byte[] file(String groupName, String fileName, int i) {
        try {
            anInt647++;
            if (!indexReady(false)) return null;
            groupName = groupName.toLowerCase();
            fileName = fileName.toLowerCase();
            int groupId = index.groupNameTable.find(1, Class281.intHashCp1252(groupName, -29286));
            if (!isValidGroup(groupId, (byte) -40)) return null;
            if (i != -29832) isValidGroup(22, (byte) 12);
            int fileId = (index.fileNameTables[groupId].find(i ^ ~0x7486, Class281.intHashCp1252(fileName, -29286)));
            return file(-1860, groupId, fileId);
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("in.EA(" + (groupName != null ? "{...}" : "null") + ',' + (fileName != null ? "{...}" : "null") + ',' + i + ')'));
        }
    }

    private final boolean isValidGroup(int i, byte i_4_) {
        anInt646++;
        if (!indexReady(false)) return false;
        if (i < 0 || index.fileLimits.length <= i || (index.fileLimits[i] == 0)) {
            if (Class285.reportInvalidIds) throw new IllegalArgumentException(Integer.toString(i));
            return false;
        }
        return i_4_ == -40;
    }

    final byte[] file(int group, int file, int i_6_, int[] key) {
        anInt639++;
        if (i_6_ != 2) anInt669 = 51;
        if (!isValidFile(file, i_6_ + -2, group)) return null;
        if (unpacked[group] == null || unpacked[group][file] == null) {
            boolean bool = unpackFile(file, (byte) -78, key, group);
            if (!bool) {
                fetchGroup(group, -117);
                bool = unpackFile(file, (byte) -103, key, group);
                if (!bool) return null;
            }
        }
        byte[] data = Class50_Sub1.unwrap(false, unpacked[group][file], 53146732);
        if (this.discardUnpacked == 1) {
            unpacked[group][file] = null;
            if (index.fileLimits[group] == 1) unpacked[group] = null;
        } else if (this.discardUnpacked == 2) unpacked[group] = null;
        return data;
    }

    private final boolean unpackFile(int fileId, byte i_8_, int[] key, int groupId) {
        anInt628++;
        if (!isValidGroup(groupId, (byte) -40)) return false;
        if (packed[groupId] == null) return false;
        int count = index.fileCounts[groupId];
        int[] ids = index.fileIds[groupId];
        if (unpacked[groupId] == null) {
            unpacked[groupId] = new Object[index.fileLimits[groupId]];
        }
        Object[] groupData = unpacked[groupId];
        boolean done = true;
        for (int i = 0; count > i; i++) {
            int id;
            if (ids == null) id = i;
            else id = ids[i];
            if (groupData[id] == null) {
                done = false;
                break;
            }
        }
        if (done) return true;
        byte[] unpacked;
        if (key == null || (key[0] == 0 && key[1] == 0 && key[2] == 0 && key[3] == 0)) unpacked = Class50_Sub1.unwrap(false, packed[groupId], 53146732);
        else {
            unpacked = Class50_Sub1.unwrap(true, packed[groupId], 53146732);
            Packet packet = new Packet(unpacked);
            packet.tinyDec(607818341, key, 5, (packet.aByteArray7154).length);
        }
        byte[] data;
        try {
            data = Class348_Sub41.decompress(unpacked, -120);
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("T3 - " + (key != null) + "," + groupId + "," + unpacked.length + "," + Class59_Sub1.method554(5126, unpacked.length, unpacked) + "," + Class59_Sub1.method554(5126, -2 + unpacked.length, unpacked) + "," + index.anIntArray3729[groupId] + "," + index.anInt3719));
        }
        if (discardPacked) packed[groupId] = null;
        if (i_8_ >= -17) fileReady((byte) 70, -7);
        if (count > 1) {
            if (this.discardUnpacked == 2) {
                int pos = data.length;
                int blocks = 0xff & data[--pos];
                pos -= 4 * (blocks * count);
                Packet packet = new Packet(data);
                int size = 0;
                int target = 0;
                packet.pos = pos;
                for (int i = 0; i < blocks; i++) {
                    int off = 0;
                    for (int j = 0; j < count; j++) {
                        off += packet.readInt((byte) -126);
                        int id;
                        if (ids == null) id = j;
                        else id = ids[j];
                        if (fileId == id) {
                            target = id;
                            size += off;
                        }
                    }
                }
                if (size == 0) return true;
                byte[] fileData = new byte[size];
                packet.pos = pos;
                size = 0;
                int off = 0;
                for (int i = 0; i < blocks; i++) {
                    int len = 0;
                    for (int j = 0; j < count; j++) {
                        len += packet.readInt((byte) -126);
                        int id;
                        if (ids != null) id = ids[j];
                        else id = j;
                        if (id == fileId) {
                            Class214.copy(data, off, fileData, size, len);
                            size += len;
                        }
                        off += len;
                    }
                }
                groupData[target] = fileData;
            } else {
                int pos = data.length;
                int blocks = 0xff & data[--pos];
                pos -= 4 * (count * blocks);
                Packet packet = new Packet(data);
                int[] sizes = new int[count];
                packet.pos = pos;
                for (int i = 0; i < blocks; i++) {
                    int size = 0;
                    for (int j = 0; j < count; j++) {
                        size += packet.readInt((byte) -126);
                        sizes[j] += size;
                    }
                }
                byte[][] files = new byte[count][];
                for (int i = 0; count > i; i++) {
                    files[i] = new byte[sizes[i]];
                    sizes[i] = 0;
                }
                packet.pos = pos;
                int off = 0;
                for (int i = 0; i < blocks; i++) {
                    int size = 0;
                    for (int j = 0; count > j; j++) {
                        size += packet.readInt((byte) -126);
                        Class214.copy(data, off, files[j], sizes[j], size);
                        off += size;
                        sizes[j] += size;
                    }
                }
                for (int i = 0; count > i; i++) {
                    int id;
                    if (ids == null) id = i;
                    else id = ids[i];
                    if (this.discardUnpacked != 0) groupData[id] = files[i];
                    else groupData[id] = Class179.wrap(files[i], false, (byte) 126);
                }
            }
        } else {
            int id;
            if (ids != null) id = ids[0];
            else id = 0;
            if (this.discardUnpacked != 0) groupData[id] = data;
            else groupData[id] = Class179.wrap(data, false, (byte) 104);
        }
        return true;
    }

    static final void method395(int i) throws Exception_Sub1 {
        if (Packet.anInt7207 == 1) Class21.aToolkit326.method3626(Class339.anInt4211, TextureOpPerlinNoise.anInt9157);
        else Class21.aToolkit326.method3626(0, 0);
        if (i >= 73) anInt642++;
    }

    final int[] fileIds(int groupId, int i_45_) {
        anInt640++;
        if (i_45_ != 0) indexCrc(-55);
        if (!isValidGroup(groupId, (byte) -40)) return null;
        int[] fileIds = index.fileIds[groupId];
        if (fileIds == null) {
            fileIds = new int[index.fileCounts[groupId]];
            for (int fileId = 0; fileId < fileIds.length; fileId++)
                fileIds[fileId] = fileId;
        }
        return fileIds;
    }

    final int completePercentage(String groupName, int i) {
        anInt633++;
        if (!indexReady(false)) return 0;
        groupName = groupName.toLowerCase();
        if (i != 0) provider = null;
        int groupId = index.groupNameTable.find(1, Class281.intHashCp1252(groupName, i ^ ~0x7265));
        return completePercentage(i, groupId);
    }

    // method398
    final int completePercentage(byte j) {
        anInt641++;
        if (!indexReady(false)) return 0;
        int total = 0;
        int percentage = 0;
        int i = 0;
        if (j != -31) return 50;
        for (/**/; packed.length > i; i++) {
            if (index.fileCounts[i] > 0) {
                percentage += completePercentage(0, i);
                total += 100;
            }
        }
        if (total == 0) return 100;
        return percentage * 100 / total;
    }

    private final boolean indexReady(boolean bool) {
        anInt652++;
        if (index == null) {
            index = provider.index((byte) 56);
            if (index == null) return false;
            packed = new Object[index.groupLimit];
            unpacked = new Object[index.groupLimit][];
        }
        if (bool) provider = null;
        return true;
    }

    final boolean groupExists(int i, String groupName) {
        anInt635++;
        if (!indexReady(false)) return false;
        if (i != -18308) return false;
        groupName = groupName.toLowerCase();
        int groupId = index.groupNameTable.find(1, Class281.intHashCp1252(groupName, -29286));
        return groupId >= 0;
    }

    final boolean isComplete(int i) {
        anInt648++;
        if (!indexReady(false)) return false;
        boolean bool = true;
        for (int i_53_ = 0; (i_53_ < index.anIntArray3738.length); i_53_++) {
            int i_54_ = index.anIntArray3738[i_53_];
            if (packed[i_54_] == null) {
                fetchGroup(i_54_, -128);
                if (packed[i_54_] == null) bool = false;
            }
        }
        if (i < 33) fileLimit(100, -92);
        return bool;
    }

    private final void requestGroup(int groupId) {
        anInt658++;
        provider.requestGroup((byte) -52, groupId);
    }

    private final boolean request(String groupName, int i, String fileName) {
        try {
            anInt626++;
            if (!indexReady(false)) return false;
            groupName = groupName.toLowerCase();
            fileName = fileName.toLowerCase();
            int groupId = (index.groupNameTable.find(i ^ 0x1c1a, Class281.intHashCp1252(groupName, -29286)));
            if (i != 7195) request(null, -20, null);
            if (!isValidGroup(groupId, (byte) -40)) return false;
            int fileId = index.fileNameTables[groupId].find(1, Class281.intHashCp1252(fileName, -29286));
            return requestDownload(i + -17694, groupId, fileId);
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("in.Q(" + (groupName != null ? "{...}" : "null") + ',' + i + ',' + (fileName != null ? "{...}" : "null") + ')'));
        }
    }

    final void clear(int i, boolean files, boolean groups) {
        anInt644++;
        if (i != 0) file(null, null, -3);
        if (indexReady(false)) {
            if (groups) {
                index.groupNames = null;
                index.groupNameTable = null;
            }
            if (files) {
                index.fileNames = null;
                index.fileNameTables = null;
            }
        }
    }

    final void discardPacked(int i) {
        anInt650++;
        if (i != 0) fileReady((byte) -45, null);
        if (packed != null) {
            for (int i_60_ = 0; i_60_ < packed.length; i_60_++)
                packed[i_60_] = null;
        }
    }

    private final void fetchGroup(int groupId, int i_61_) {
        if (i_61_ > -105) unpacked = null;
        if (discardPacked) {
            packed[groupId] = provider.fetchGroup(groupId, (byte) 12);
        } else {
            packed[groupId] = Class179.wrap(provider.fetchGroup(groupId, (byte) 73), false, (byte) 123);
        }
        anInt665++;
    }

    final int fileLimit(int i, int groupId) {
        if (i != 0) indexCrc(-61);
        anInt645++;
        if (!isValidGroup(groupId, (byte) -40)) return 0;
        return index.fileLimits[groupId];
    }

    final boolean requestGroup(byte i, int groupId) {
        anInt632++;
        if (!isValidGroup(groupId, (byte) -40)) return false;
        if (packed[groupId] != null) return true;
        fetchGroup(groupId, -124);
        if (packed[groupId] != null) return true;
        if (i > -112) this.discardUnpacked = -26;
        return false;
    }

    final void requestGroup(String string, boolean bool) {
        anInt663++;
        if (bool == true && indexReady(false)) {
            string = string.toLowerCase();
            int i = index.groupNameTable.find(1, Class281.intHashCp1252(string, -29286));
            requestGroup(i);
        }
    }

    final byte[] file(int i, int i_64_, int i_65_) {
        if (i != -1860) unpacked = null;
        anInt651++;
        return file(i_64_, i_65_, i ^ ~0x741, null);
    }

    final void discardUnpacked(int groupId, int i_66_) {
        anInt627++;
        if (i_66_ > -9) unpackFile(-111, (byte) -98, null, -71);
        if (isValidGroup(groupId, (byte) -40)) {
            if (unpacked != null) unpacked[groupId] = null;
        }
    }

    final void discardUnpacked(byte i) {
        if (unpacked != null) {
            for (int i_67_ = 0; unpacked.length > i_67_; i_67_++)
                unpacked[i_67_] = null;
        }
        int i_68_ = 52 % ((-46 - i) / 62);
        anInt660++;
    }

    final boolean requestGroup(int i, String groupName) {
        anInt636++;
        if (!indexReady(false)) return false;
        groupName = groupName.toLowerCase();
        int groupId = index.groupNameTable.find(i + -99, Class281.intHashCp1252(groupName, -29286));
        if (i != 100) aFloat670 = 0.37849286F;
        return requestGroup((byte) -120, groupId);
    }

    final int groupSize(int i) {
        anInt637++;
        if (i != -1) return 49;
        if (!indexReady(false)) return -1;
        return index.fileLimits.length;
    }

    final byte[] fileReady(byte i, int id) {
        anInt630++;
        if (!indexReady(false)) return null;
        if (index.fileLimits.length == 1) return file(i ^ ~0x70a, 0, id);
        if (!isValidGroup(id, (byte) -40)) return null;
        if (i != 73) unpacked = null;
        if (index.fileLimits[id] == 1) return file(i ^ ~0x70a, id, 0);
        throw new RuntimeException();
    }

    final boolean fileReady(byte i, String fileName) {
        anInt631++;
        int i_71_ = groupId("", i + 74);
        if (i_71_ != -1) return request("", 7195, fileName);
        if (i != -74) return false;
        return request(fileName, 7195, "");
    }

    final int groupId(String groupName, int i) {
        if (i != 0) return 113;
        anInt654++;
        if (!indexReady(false)) return -1;
        groupName = groupName.toLowerCase();
        int groupId = index.groupNameTable.find(1, Class281.intHashCp1252(groupName, -29286));
        if (!isValidGroup(groupId, (byte) -40)) return -1;
        return groupId;
    }

    private final boolean isValidFile(int file, int i_73_, int group) {
        anInt662++;
        if (!indexReady(false)) return false;
        if (group < i_73_ || file < 0 || (index.fileLimits.length <= group) || (index.fileLimits[group] <= file)) {
            if (Class285.reportInvalidIds) throw new IllegalArgumentException(group + "," + file);
            return false;
        }
        return true;
    }

    private final int completePercentage(int i, int groupId) {
        if (i != 0) return -117;
        anInt653++;
        if (!isValidGroup(groupId, (byte) -40)) return 0;
        if (packed[groupId] != null) return 100;
        return provider.completePercentage(groupId, i + -22197);
    }

    // method420
    final boolean requestDownload(int i, int i_76_, int i_77_) {
        anInt638++;
        if (!isValidFile(i_77_, 0, i_76_)) return false;
        if (unpacked[i_76_] != null && unpacked[i_76_][i_77_] != null) return true;
        if (i != -10499) return true;
        if (packed[i_76_] != null) return true;
        fetchGroup(i_76_, -125);
        return packed[i_76_] != null;
    }

    // method421
    final boolean fileReady(boolean bool, int i) {
        anInt661++;
        if (!indexReady(bool)) return false;
        if (index.fileLimits.length == 1) return requestDownload(-10499, 0, i);
        if (!isValidGroup(i, (byte) -40)) return false;
        if (index.fileLimits[i] == 1) return requestDownload(-10499, i, 0);
        if (bool != false) return false;
        throw new RuntimeException();
    }

    final boolean fileExists(String fileName, String groupName, int i) {
        try {
            anInt668++;
            if (!indexReady(false)) return false;
            groupName = groupName.toLowerCase();
            if (i > -18) anInt669 = 40;
            fileName = fileName.toLowerCase();
            int groupId = index.groupNameTable.find(1, Class281.intHashCp1252(groupName, -29286));
            if (groupId < 0) return false;
            int fileId = index.fileNameTables[groupId].find(1, Class281.intHashCp1252(fileName, -29286));
            return fileId >= 0;
        } catch (RuntimeException runtimeexception) {
            throw Class348_Sub17.method2929(runtimeexception, ("in.M(" + (fileName != null ? "{...}" : "null") + ',' + (groupName != null ? "{...}" : "null") + ',' + i + ')'));
        }
    }

    final int groupId(int name, byte i_81_) {
        anInt649++;
        if (!indexReady(false)) return -1;
        int groupId = index.groupNameTable.find(1, name);
        if (!isValidGroup(groupId, (byte) -40)) return -1;
        return groupId;
    }

    Index(ResourceProvider resourceProvider, boolean bool, int i) {
        if (i < 0 || i > 2) throw new IllegalArgumentException("js5: Invalid value " + i + " supplied for discardunpacked");
        provider = resourceProvider;
        discardPacked = bool;
        this.discardUnpacked = i;
    }

    static {
        anInt666 = 100;
    }
}
