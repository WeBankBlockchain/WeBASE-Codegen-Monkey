package org.bcos.depot.contract;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.bcos.web3j.abi.EventEncoder;
import org.bcos.web3j.abi.EventValues;
import org.bcos.web3j.abi.FunctionEncoder;
import org.bcos.web3j.abi.TypeReference;
import org.bcos.web3j.abi.datatypes.Address;
import org.bcos.web3j.abi.datatypes.Bool;
import org.bcos.web3j.abi.datatypes.DynamicArray;
import org.bcos.web3j.abi.datatypes.Event;
import org.bcos.web3j.abi.datatypes.Function;
import org.bcos.web3j.abi.datatypes.Type;
import org.bcos.web3j.abi.datatypes.Utf8String;
import org.bcos.web3j.abi.datatypes.generated.Bytes32;
import org.bcos.web3j.abi.datatypes.generated.Uint8;
import org.bcos.web3j.crypto.Credentials;
import org.bcos.web3j.protocol.Web3j;
import org.bcos.web3j.protocol.core.DefaultBlockParameter;
import org.bcos.web3j.protocol.core.methods.request.EthFilter;
import org.bcos.web3j.protocol.core.methods.response.Log;
import org.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.bcos.web3j.tx.Contract;
import org.bcos.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>, or {@link org.bcos.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version none.
 */
public final class Evidence extends Contract {
    private static final String BINARY = "606060405234156200001057600080fd5b604051620021f6380380620021f68339810160405280805182019190602001805182019190602001805182019190602001805190602001909190805190602001909190805190602001909190805190602001909190805190602001909190505081600760006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550620000d081620006056401000000000262001743176401000000009004565b1562000415578760009080519060200190620000ee929190620006f0565b50866001908051906020019062000107929190620006f0565b50856002908051906020019062000120929190620006f0565b506003805480600101828162000137919062000777565b916000526020600020906020918282040191900687909190916101000a81548160ff021916908360ff16021790555050600480548060010182816200017d9190620007b4565b91600052602060002090016000869091909150906000191690555060058054806001018281620001ae9190620007b4565b91600052602060002090016000859091909150906000191690555060068054806001018281620001df9190620007e3565b9160005260206000209001600083909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550507f6001b9d5afd61e6053e8a73e30790ef8240d919a754055049131521927fbe21188888888888888604051808060200180602001806020018860ff1660ff168152602001876000191660001916815260200186600019166000191681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200184810384528b818151815260200191508051906020019080838360005b83811015620002fa578082015181840152602081019050620002dd565b50505050905090810190601f168015620003285780820380516001836020036101000a031916815260200191505b5084810383528a818151815260200191508051906020019080838360005b838110156200036357808201518184015260208101905062000346565b50505050905090810190601f168015620003915780820380516001836020036101000a031916815260200191505b50848103825289818151815260200191508051906020019080838360005b83811015620003cc578082015181840152602081019050620003af565b50505050905090810190601f168015620003fa5780820380516001836020036101000a031916815260200191505b509a505050505050505050505060405180910390a1620005f7565b7f45cb885dcdccd3bece3cb78b963aec501f1cf9756fd93584f0643c7a9533431088888888888888604051808060200180602001806020018860ff1660ff168152602001876000191660001916815260200186600019166000191681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200184810384528b818151815260200191508051906020019080838360005b83811015620004e1578082015181840152602081019050620004c4565b50505050905090810190601f1680156200050f5780820380516001836020036101000a031916815260200191505b5084810383528a818151815260200191508051906020019080838360005b838110156200054a5780820151818401526020810190506200052d565b50505050905090810190601f168015620005785780820380516001836020036101000a031916815260200191505b50848103825289818151815260200191508051906020019080838360005b83811015620005b357808201518184015260208101905062000596565b50505050905090810190601f168015620005e15780820380516001836020036101000a031916815260200191505b509a505050505050505050505060405180910390a15b505050505050505062000862565b6000600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166363a9c3d7836000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b1515620006cd57600080fd5b6102c65a03f11515620006df57600080fd5b505050604051805190509050919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200073357805160ff191683800117855562000764565b8280016001018555821562000764579182015b828111156200076357825182559160200191906001019062000746565b5b50905062000773919062000812565b5090565b815481835581811511620007af57601f016020900481601f01602090048360005260206000209182019101620007ae919062000812565b5b505050565b815481835581811511620007de57818360005260206000209182019101620007dd91906200083a565b5b505050565b8154818355818115116200080d578183600052602060002091820191016200080c919062000812565b5b505050565b6200083791905b808211156200083357600081600090555060010162000819565b5090565b90565b6200085f91905b808211156200085b57600081600090555060010162000841565b5090565b90565b61198480620008726000396000f30060606040523615610076576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680633b52ebd01461007b57806348f85bce146100d0578063596f21f81461012857806394cf795e146103ae578063c7eaf9b414610418578063dc58ab11146104a6575b600080fd5b341561008657600080fd5b61008e6104f7565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34156100db57600080fd5b61010e600480803560ff16906020019091908035600019169060200190919080356000191690602001909190505061051d565b604051808215151515815260200191505060405180910390f35b341561013357600080fd5b61013b610f53565b604051808060200180602001806020018060200180602001806020018060200188810388528f818151815260200191508051906020019080838360005b83811015610193578082015181840152602081019050610178565b50505050905090810190601f1680156101c05780820380516001836020036101000a031916815260200191505b5088810387528e818151815260200191508051906020019080838360005b838110156101f95780820151818401526020810190506101de565b50505050905090810190601f1680156102265780820380516001836020036101000a031916815260200191505b5088810386528d818151815260200191508051906020019080838360005b8381101561025f578082015181840152602081019050610244565b50505050905090810190601f16801561028c5780820380516001836020036101000a031916815260200191505b5088810385528c818151815260200191508051906020019060200280838360005b838110156102c85780820151818401526020810190506102ad565b5050505090500188810384528b818151815260200191508051906020019060200280838360005b8381101561030a5780820151818401526020810190506102ef565b5050505090500188810383528a818151815260200191508051906020019060200280838360005b8381101561034c578082015181840152602081019050610331565b50505050905001888103825289818151815260200191508051906020019060200280838360005b8381101561038e578082015181840152602081019050610373565b505050509050019e50505050505050505050505050505060405180910390f35b34156103b957600080fd5b6103c161149a565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156104045780820151818401526020810190506103e9565b505050509050019250505060405180910390f35b341561042357600080fd5b61042b61169b565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561046b578082015181840152602081019050610450565b50505050905090810190601f1680156104985780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34156104b157600080fd5b6104dd600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050611743565b604051808215151515815260200191505060405180910390f35b600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600080600090505b6006805490508110156109fa5760068181548110151561054157fe5b906000526020600020900160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614156109ed578460ff166003828154811015156105b357fe5b90600052602060002090602091828204019190069054906101000a900460ff1660ff16148015610604575083600019166004828154811015156105f257fe5b90600052602060002090015460001916145b80156106315750826000191660058281548110151561061f57fe5b90600052602060002090015460001916145b1561083d577fcb265a1c827beb2fd9947f2a8d4725c8918f266faf695a26a53ac662e42a2f3f600060016002888888604051808060200180602001806020018760ff1660ff1681526020018660001916600019168152602001856000191660001916815260200184810384528a8181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156107195780601f106106ee57610100808354040283529160200191610719565b820191906000526020600020905b8154815290600101906020018083116106fc57829003601f168201915b505084810383528981815460018160011615610100020316600290048152602001915080546001816001161561010002031660029004801561079c5780601f106107715761010080835404028352916020019161079c565b820191906000526020600020905b81548152906001019060200180831161077f57829003601f168201915b505084810382528881815460018160011615610100020316600290048152602001915080546001816001161561010002031660029004801561081f5780601f106107f45761010080835404028352916020019161081f565b820191906000526020600020905b81548152906001019060200180831161080257829003601f168201915b5050995050505050505050505060405180910390a160019150610f4b565b7f05e85d72e83e8d2c8c877a19dd3a15c60415f315dc6d176b21537216537d275760006002878787336040518080602001806020018760ff1660ff168152602001866000191660001916815260200185600019166000191681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200183810383528981815460018160011615610100020316600290048152602001915080546001816001161561010002031660029004801561094d5780601f106109225761010080835404028352916020019161094d565b820191906000526020600020905b81548152906001019060200180831161093057829003601f168201915b50508381038252888181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156109d05780601f106109a5576101008083540402835291602001916109d0565b820191906000526020600020905b8154815290600101906020018083116109b357829003601f168201915b50509850505050505050505060405180910390a160009150610f4b565b8080600101915050610525565b610a0333611743565b15610d145760038054806001018281610a1c919061182c565b916000526020600020906020918282040191900687909190916101000a81548160ff021916908360ff1602179055505060048054806001018281610a609190611866565b91600052602060002090016000869091909150906000191690555060058054806001018281610a8f9190611866565b91600052602060002090016000859091909150906000191690555060068054806001018281610abe9190611892565b9160005260206000209001600033909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550507fbf474e795141390215f4f179557402a28c562b860f7b74dce4a3c0e0604cd97e600060016002888888604051808060200180602001806020018760ff1660ff1681526020018660001916600019168152602001856000191660001916815260200184810384528a818154600181600116156101000203166002900481526020019150805460018160011615610100020316600290048015610bf05780601f10610bc557610100808354040283529160200191610bf0565b820191906000526020600020905b815481529060010190602001808311610bd357829003601f168201915b5050848103835289818154600181600116156101000203166002900481526020019150805460018160011615610100020316600290048015610c735780601f10610c4857610100808354040283529160200191610c73565b820191906000526020600020905b815481529060010190602001808311610c5657829003601f168201915b5050848103825288818154600181600116156101000203166002900481526020019150805460018160011615610100020316600290048015610cf65780601f10610ccb57610100808354040283529160200191610cf6565b820191906000526020600020905b815481529060010190602001808311610cd957829003601f168201915b5050995050505050505050505060405180910390a160019150610f4b565b7fc585b66a303b685f03874907af9278712998ea1acfed37bcb4277da02cddb8b460006001600288888833604051808060200180602001806020018860ff1660ff168152602001876000191660001916815260200186600019166000191681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200184810384528b818154600181600116156101000203166002900481526020019150805460018160011615610100020316600290048015610e2a5780601f10610dff57610100808354040283529160200191610e2a565b820191906000526020600020905b815481529060010190602001808311610e0d57829003601f168201915b505084810383528a818154600181600116156101000203166002900481526020019150805460018160011615610100020316600290048015610ead5780601f10610e8257610100808354040283529160200191610ead565b820191906000526020600020905b815481529060010190602001808311610e9057829003601f168201915b5050848103825289818154600181600116156101000203166002900481526020019150805460018160011615610100020316600290048015610f305780601f10610f0557610100808354040283529160200191610f30565b820191906000526020600020905b815481529060010190602001808311610f1357829003601f168201915b50509a505050505050505050505060405180910390a1600091505b509392505050565b610f5b6118be565b610f636118be565b610f6b6118be565b610f736118d2565b610f7b6118e6565b610f836118e6565b610f8b6118fa565b6000610f956118fa565b6000600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663fa69efbd6000604051602001526040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b151561102557600080fd5b6102c65a03f1151561103657600080fd5b505050604051805190509250826040518059106110505750595b90808252806020026020018201604052509150600090505b8281101561117b57600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16633ffefe4e826000604051602001526040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050602060405180830381600087803b151561110957600080fd5b6102c65a03f1151561111a57600080fd5b50505060405180519050828281518110151561113257fe5b9060200190602002019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff16815250508080600101915050611068565b60006001600260036004600587868054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561121d5780601f106111f25761010080835404028352916020019161121d565b820191906000526020600020905b81548152906001019060200180831161120057829003601f168201915b50505050509650858054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156112b95780601f1061128e576101008083540402835291602001916112b9565b820191906000526020600020905b81548152906001019060200180831161129c57829003601f168201915b50505050509550848054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156113555780601f1061132a57610100808354040283529160200191611355565b820191906000526020600020905b81548152906001019060200180831161133857829003601f168201915b50505050509450838054806020026020016040519081016040528092919081815260200182805480156113cd57602002820191906000526020600020906000905b82829054906101000a900460ff1660ff16815260200190600101906020826000010492830192600103820291508084116113965790505b505050505093508280548060200260200160405190810160405280929190818152602001828054801561142357602002820191906000526020600020905b8154600019168152602001906001019080831161140b575b505050505092508180548060200260200160405190810160405280929190818152602001828054801561147957602002820191906000526020600020905b81546000191681526020019060010190808311611461575b50505050509150995099509950995099509950995050505090919293949596565b6114a26118fa565b60006114ac6118fa565b6000600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663fa69efbd6000604051602001526040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b151561153c57600080fd5b6102c65a03f1151561154d57600080fd5b505050604051805190509250826040518059106115675750595b90808252806020026020018201604052509150600090505b8281101561169257600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16633ffefe4e826000604051602001526040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050602060405180830381600087803b151561162057600080fd5b6102c65a03f1151561163157600080fd5b50505060405180519050828281518110151561164957fe5b9060200190602002019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff1681525050808060010191505061157f565b81935050505090565b6116a36118be565b60018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156117395780601f1061170e57610100808354040283529160200191611739565b820191906000526020600020905b81548152906001019060200180831161171c57829003601f168201915b5050505050905090565b6000600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166363a9c3d7836000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b151561180a57600080fd5b6102c65a03f1151561181b57600080fd5b505050604051805190509050919050565b81548183558181151161186157601f016020900481601f01602090048360005260206000209182019101611860919061190e565b5b505050565b81548183558181151161188d5781836000526020600020918201910161188c9190611933565b5b505050565b8154818355818115116118b9578183600052602060002091820191016118b8919061190e565b5b505050565b602060405190810160405280600081525090565b602060405190810160405280600081525090565b602060405190810160405280600081525090565b602060405190810160405280600081525090565b61193091905b8082111561192c576000816000905550600101611914565b5090565b90565b61195591905b80821115611951576000816000905550600101611939565b5090565b905600a165627a7a72305820b683c7e36460d7055cdd101fc623eb87481cb4f4b2425b33880c23595ec182420029";

    private Evidence(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private Evidence(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<AddSignaturesEventEventResponse> getAddSignaturesEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("addSignaturesEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<AddSignaturesEventEventResponse> responses = new ArrayList<AddSignaturesEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            AddSignaturesEventEventResponse typedResponse = new AddSignaturesEventEventResponse();
            typedResponse.evi = (Utf8String) eventValues.getNonIndexedValues().get(0);
            typedResponse.info = (Utf8String) eventValues.getNonIndexedValues().get(1);
            typedResponse.id = (Utf8String) eventValues.getNonIndexedValues().get(2);
            typedResponse.v = (Uint8) eventValues.getNonIndexedValues().get(3);
            typedResponse.r = (Bytes32) eventValues.getNonIndexedValues().get(4);
            typedResponse.s = (Bytes32) eventValues.getNonIndexedValues().get(5);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<AddSignaturesEventEventResponse> addSignaturesEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("addSignaturesEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, AddSignaturesEventEventResponse>() {
            @Override
            public AddSignaturesEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                AddSignaturesEventEventResponse typedResponse = new AddSignaturesEventEventResponse();
                typedResponse.evi = (Utf8String) eventValues.getNonIndexedValues().get(0);
                typedResponse.info = (Utf8String) eventValues.getNonIndexedValues().get(1);
                typedResponse.id = (Utf8String) eventValues.getNonIndexedValues().get(2);
                typedResponse.v = (Uint8) eventValues.getNonIndexedValues().get(3);
                typedResponse.r = (Bytes32) eventValues.getNonIndexedValues().get(4);
                typedResponse.s = (Bytes32) eventValues.getNonIndexedValues().get(5);
                return typedResponse;
            }
        });
    }

    public List<NewSignaturesEventEventResponse> getNewSignaturesEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("newSignaturesEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<NewSignaturesEventEventResponse> responses = new ArrayList<NewSignaturesEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            NewSignaturesEventEventResponse typedResponse = new NewSignaturesEventEventResponse();
            typedResponse.evi = (Utf8String) eventValues.getNonIndexedValues().get(0);
            typedResponse.info = (Utf8String) eventValues.getNonIndexedValues().get(1);
            typedResponse.id = (Utf8String) eventValues.getNonIndexedValues().get(2);
            typedResponse.v = (Uint8) eventValues.getNonIndexedValues().get(3);
            typedResponse.r = (Bytes32) eventValues.getNonIndexedValues().get(4);
            typedResponse.s = (Bytes32) eventValues.getNonIndexedValues().get(5);
            typedResponse.addr = (Address) eventValues.getNonIndexedValues().get(6);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<NewSignaturesEventEventResponse> newSignaturesEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("newSignaturesEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, NewSignaturesEventEventResponse>() {
            @Override
            public NewSignaturesEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                NewSignaturesEventEventResponse typedResponse = new NewSignaturesEventEventResponse();
                typedResponse.evi = (Utf8String) eventValues.getNonIndexedValues().get(0);
                typedResponse.info = (Utf8String) eventValues.getNonIndexedValues().get(1);
                typedResponse.id = (Utf8String) eventValues.getNonIndexedValues().get(2);
                typedResponse.v = (Uint8) eventValues.getNonIndexedValues().get(3);
                typedResponse.r = (Bytes32) eventValues.getNonIndexedValues().get(4);
                typedResponse.s = (Bytes32) eventValues.getNonIndexedValues().get(5);
                typedResponse.addr = (Address) eventValues.getNonIndexedValues().get(6);
                return typedResponse;
            }
        });
    }

    public List<ErrorNewSignaturesEventEventResponse> getErrorNewSignaturesEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("errorNewSignaturesEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<ErrorNewSignaturesEventEventResponse> responses = new ArrayList<ErrorNewSignaturesEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            ErrorNewSignaturesEventEventResponse typedResponse = new ErrorNewSignaturesEventEventResponse();
            typedResponse.evi = (Utf8String) eventValues.getNonIndexedValues().get(0);
            typedResponse.info = (Utf8String) eventValues.getNonIndexedValues().get(1);
            typedResponse.id = (Utf8String) eventValues.getNonIndexedValues().get(2);
            typedResponse.v = (Uint8) eventValues.getNonIndexedValues().get(3);
            typedResponse.r = (Bytes32) eventValues.getNonIndexedValues().get(4);
            typedResponse.s = (Bytes32) eventValues.getNonIndexedValues().get(5);
            typedResponse.addr = (Address) eventValues.getNonIndexedValues().get(6);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ErrorNewSignaturesEventEventResponse> errorNewSignaturesEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("errorNewSignaturesEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, ErrorNewSignaturesEventEventResponse>() {
            @Override
            public ErrorNewSignaturesEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                ErrorNewSignaturesEventEventResponse typedResponse = new ErrorNewSignaturesEventEventResponse();
                typedResponse.evi = (Utf8String) eventValues.getNonIndexedValues().get(0);
                typedResponse.info = (Utf8String) eventValues.getNonIndexedValues().get(1);
                typedResponse.id = (Utf8String) eventValues.getNonIndexedValues().get(2);
                typedResponse.v = (Uint8) eventValues.getNonIndexedValues().get(3);
                typedResponse.r = (Bytes32) eventValues.getNonIndexedValues().get(4);
                typedResponse.s = (Bytes32) eventValues.getNonIndexedValues().get(5);
                typedResponse.addr = (Address) eventValues.getNonIndexedValues().get(6);
                return typedResponse;
            }
        });
    }

    public List<ErrorAddSignaturesEventEventResponse> getErrorAddSignaturesEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("errorAddSignaturesEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<ErrorAddSignaturesEventEventResponse> responses = new ArrayList<ErrorAddSignaturesEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            ErrorAddSignaturesEventEventResponse typedResponse = new ErrorAddSignaturesEventEventResponse();
            typedResponse.evi = (Utf8String) eventValues.getNonIndexedValues().get(0);
            typedResponse.info = (Utf8String) eventValues.getNonIndexedValues().get(1);
            typedResponse.id = (Utf8String) eventValues.getNonIndexedValues().get(2);
            typedResponse.v = (Uint8) eventValues.getNonIndexedValues().get(3);
            typedResponse.r = (Bytes32) eventValues.getNonIndexedValues().get(4);
            typedResponse.s = (Bytes32) eventValues.getNonIndexedValues().get(5);
            typedResponse.addr = (Address) eventValues.getNonIndexedValues().get(6);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ErrorAddSignaturesEventEventResponse> errorAddSignaturesEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("errorAddSignaturesEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, ErrorAddSignaturesEventEventResponse>() {
            @Override
            public ErrorAddSignaturesEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                ErrorAddSignaturesEventEventResponse typedResponse = new ErrorAddSignaturesEventEventResponse();
                typedResponse.evi = (Utf8String) eventValues.getNonIndexedValues().get(0);
                typedResponse.info = (Utf8String) eventValues.getNonIndexedValues().get(1);
                typedResponse.id = (Utf8String) eventValues.getNonIndexedValues().get(2);
                typedResponse.v = (Uint8) eventValues.getNonIndexedValues().get(3);
                typedResponse.r = (Bytes32) eventValues.getNonIndexedValues().get(4);
                typedResponse.s = (Bytes32) eventValues.getNonIndexedValues().get(5);
                typedResponse.addr = (Address) eventValues.getNonIndexedValues().get(6);
                return typedResponse;
            }
        });
    }

    public List<AddRepeatSignaturesEventEventResponse> getAddRepeatSignaturesEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("addRepeatSignaturesEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<AddRepeatSignaturesEventEventResponse> responses = new ArrayList<AddRepeatSignaturesEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            AddRepeatSignaturesEventEventResponse typedResponse = new AddRepeatSignaturesEventEventResponse();
            typedResponse.evi = (Utf8String) eventValues.getNonIndexedValues().get(0);
            typedResponse.info = (Utf8String) eventValues.getNonIndexedValues().get(1);
            typedResponse.id = (Utf8String) eventValues.getNonIndexedValues().get(2);
            typedResponse.v = (Uint8) eventValues.getNonIndexedValues().get(3);
            typedResponse.r = (Bytes32) eventValues.getNonIndexedValues().get(4);
            typedResponse.s = (Bytes32) eventValues.getNonIndexedValues().get(5);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<AddRepeatSignaturesEventEventResponse> addRepeatSignaturesEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("addRepeatSignaturesEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, AddRepeatSignaturesEventEventResponse>() {
            @Override
            public AddRepeatSignaturesEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                AddRepeatSignaturesEventEventResponse typedResponse = new AddRepeatSignaturesEventEventResponse();
                typedResponse.evi = (Utf8String) eventValues.getNonIndexedValues().get(0);
                typedResponse.info = (Utf8String) eventValues.getNonIndexedValues().get(1);
                typedResponse.id = (Utf8String) eventValues.getNonIndexedValues().get(2);
                typedResponse.v = (Uint8) eventValues.getNonIndexedValues().get(3);
                typedResponse.r = (Bytes32) eventValues.getNonIndexedValues().get(4);
                typedResponse.s = (Bytes32) eventValues.getNonIndexedValues().get(5);
                return typedResponse;
            }
        });
    }

    public List<ErrorRepeatSignaturesEventEventResponse> getErrorRepeatSignaturesEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("errorRepeatSignaturesEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<ErrorRepeatSignaturesEventEventResponse> responses = new ArrayList<ErrorRepeatSignaturesEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            ErrorRepeatSignaturesEventEventResponse typedResponse = new ErrorRepeatSignaturesEventEventResponse();
            typedResponse.evi = (Utf8String) eventValues.getNonIndexedValues().get(0);
            typedResponse.id = (Utf8String) eventValues.getNonIndexedValues().get(1);
            typedResponse.v = (Uint8) eventValues.getNonIndexedValues().get(2);
            typedResponse.r = (Bytes32) eventValues.getNonIndexedValues().get(3);
            typedResponse.s = (Bytes32) eventValues.getNonIndexedValues().get(4);
            typedResponse.addr = (Address) eventValues.getNonIndexedValues().get(5);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ErrorRepeatSignaturesEventEventResponse> errorRepeatSignaturesEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("errorRepeatSignaturesEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, ErrorRepeatSignaturesEventEventResponse>() {
            @Override
            public ErrorRepeatSignaturesEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                ErrorRepeatSignaturesEventEventResponse typedResponse = new ErrorRepeatSignaturesEventEventResponse();
                typedResponse.evi = (Utf8String) eventValues.getNonIndexedValues().get(0);
                typedResponse.id = (Utf8String) eventValues.getNonIndexedValues().get(1);
                typedResponse.v = (Uint8) eventValues.getNonIndexedValues().get(2);
                typedResponse.r = (Bytes32) eventValues.getNonIndexedValues().get(3);
                typedResponse.s = (Bytes32) eventValues.getNonIndexedValues().get(4);
                typedResponse.addr = (Address) eventValues.getNonIndexedValues().get(5);
                return typedResponse;
            }
        });
    }

    public Future<Address> signersAddr() {
        Function function = new Function("signersAddr", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> addSignatures(Uint8 v, Bytes32 r, Bytes32 s) {
        Function function = new Function("addSignatures", Arrays.<Type>asList(v, r, s), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<List<Type>> getEvidence() {
        Function function = new Function("getEvidence", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<DynamicArray<Uint8>>() {}, new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<DynamicArray<Address>>() {}));
        return executeCallMultipleValueReturnAsync(function);
    }

    public Future<DynamicArray<Address>> getSigners() {
        Function function = new Function("getSigners", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Utf8String> getEvidenceInfo() {
        Function function = new Function("getEvidenceInfo", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Bool> CallVerify(Address addr) {
        Function function = new Function("CallVerify", 
                Arrays.<Type>asList(addr), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public static Future<Evidence> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, Utf8String evi, Utf8String info, Utf8String id, Uint8 v, Bytes32 r, Bytes32 s, Address addr, Address sender) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(evi, info, id, v, r, s, addr, sender));
        return deployAsync(Evidence.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static Future<Evidence> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, Utf8String evi, Utf8String info, Utf8String id, Uint8 v, Bytes32 r, Bytes32 s, Address addr, Address sender) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(evi, info, id, v, r, s, addr, sender));
        return deployAsync(Evidence.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static Evidence load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Evidence(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Evidence load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Evidence(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class AddSignaturesEventEventResponse {
        public Utf8String evi;

        public Utf8String info;

        public Utf8String id;

        public Uint8 v;

        public Bytes32 r;

        public Bytes32 s;
    }

    public static class NewSignaturesEventEventResponse {
        public Utf8String evi;

        public Utf8String info;

        public Utf8String id;

        public Uint8 v;

        public Bytes32 r;

        public Bytes32 s;

        public Address addr;
    }

    public static class ErrorNewSignaturesEventEventResponse {
        public Utf8String evi;

        public Utf8String info;

        public Utf8String id;

        public Uint8 v;

        public Bytes32 r;

        public Bytes32 s;

        public Address addr;
    }

    public static class ErrorAddSignaturesEventEventResponse {
        public Utf8String evi;

        public Utf8String info;

        public Utf8String id;

        public Uint8 v;

        public Bytes32 r;

        public Bytes32 s;

        public Address addr;
    }

    public static class AddRepeatSignaturesEventEventResponse {
        public Utf8String evi;

        public Utf8String info;

        public Utf8String id;

        public Uint8 v;

        public Bytes32 r;

        public Bytes32 s;
    }

    public static class ErrorRepeatSignaturesEventEventResponse {
        public Utf8String evi;

        public Utf8String id;

        public Uint8 v;

        public Bytes32 r;

        public Bytes32 s;

        public Address addr;
    }
}
