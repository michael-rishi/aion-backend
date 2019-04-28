package bitecoin;

import avm.Address;
import avm.Blockchain;
import avm.Result;
import org.aion.avm.tooling.abi.Callable;

import java.math.BigInteger;

public class TransferAion {

    // Create an empty address for the owner.
    private static Address owner;

    static {
        // Set the owner as the address that deployed the contract.
        owner = Blockchain.getCaller();
    }

    // Transfer AION from the contract address to the address listed in the "to" variable.
    @Callable
    public static boolean transferAion(Address to, long value) {
        // TO-DO this is only for Demo Day
        // onlyOwner();
        Result result = Blockchain.call(to, BigInteger.valueOf(value), new byte[0], Blockchain.getRemainingEnergy());
        return result.isSuccess();
    }

    // Only Owner modifier.
    private static void onlyOwner() {
        Blockchain.require(Blockchain.getCaller().equals(owner));
    }
}