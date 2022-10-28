import React,{useEffect, useState} from "react";
import { View,Text, StyleSheet, ActivityIndicator, FlatList } from 'react-native';
import * as Animatable from 'react-native-animatable'
export default function Itinerarios (){
    const[itinerarios,setItinerarios]=useState([]);
    const[carregando,setCarregando]=useState(true);
    const getItinerarios = async () =>{
        try{
            const response = await
            fetch('http://localhost:8080/intinerarios')
            const json = await response.json();
            setItinerarios(json);
        }catch(error){(alert('Erro ao obter Itinerários! Tente novamente'))
    }finally{setCarregando(false)}
        
    }
    useEffect(()=>{
        getItinerarios();
        },[]);
    return(
        <View style={styles.container}>
        <Animatable.View animation={'fadeInLeft'}delay={500} style={styles.containerHeader} >
            <Text style={styles.title}> Itinerarios </Text>
            {
                carregando ? <ActivityIndicator/>:(
                    <FlatList
                        style={styles.containerForm}
                        data={itinerarios}
                        keyExtractor={({id},index)=>id}
                        renderItem={({item})=>(
                            <><Text style={styles.buttonText}>{item.pontoInicial}</Text>
                            <Text style={styles.buttonText}>{item.percurso}</Text>
                            <Text style={styles.buttonText}>{item.pontoFinal}</Text></>


                        )}
                        />
                )
            }
        </Animatable.View>
        </View>
    )
        }

        const styles = StyleSheet.create({
            container:{
                flex:1,
                backgroundColor:'#38a29d'
            },
            containerHeader:{
                marginTop:'14%',
                marginBottom: '8%',
                paddingStart:'5%',
            },
            message:{
                fontSize:28,
                fontWeight:"bold",
                color: '#FFF'
            },
            containerForm:{
                backgroundColor:'#FFF',
                flex:1,
                borderTopLeftRadius:25,
                borderTopRightRadius:25,
                paddingStart:'5%',
                paddingEnd:'5%'
            },
            title:{
                fontSize:20,
                marginTop:20,
            },
            button:{
                backgroundColor:'#38a29d',
                width:'100%',
                borderRadius:4,
                paddingVertical:8,
                marginTop:14,
                justifyContent:'center',
                alignItems:'center'
            },
            buttonText:{
                color:'#FFF',
                fontSize:18,
                fontWeight:'bold'
            },
            buttonRegister:{
                marginTop:14,
                alignSelf:'center'
            },
            registerText:{
                color:'#a1a1a1'
            }

        })
        